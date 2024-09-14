package com.example.composeappdemmo.pokemonlist

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.example.composeappdemmo.data.models.PokemonListEntry
import com.example.composeappdemmo.repository.PokemonRepository
import com.example.composeappdemmo.util.Constants.PAGE_SIZE
import com.example.composeappdemmo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var currentPage = 0
    var pokemonList = mutableStateOf<List<PokemonListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(true)
    var endReached = mutableStateOf(false)

    private var cachedList = listOf<PokemonListEntry>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)


    fun searchPokemonList(query: String) {
        val listToSearch = if (isSearchStarting) {
            pokemonList.value
        } else {
            cachedList
        }

        viewModelScope.launch(Dispatchers.Default) {

            if (query.isEmpty()) {
                pokemonList.value = cachedList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }else{
               val results = listToSearch.filter {
                   it.pokemonName.contains(query.trim(), ignoreCase = true) ||
                           it.number.toString() == query.trim()
               }
                if(isSearchStarting){
                    cachedList = pokemonList.value
                    isSearchStarting = false
                }
                pokemonList.value = results
                isSearching.value = true
            }

        }

    }

    init {
        paginatedPokemonList()
    }

    fun paginatedPokemonList() {
        viewModelScope.launch {
            when (val result = repository.getPokemonList(PAGE_SIZE, currentPage * PAGE_SIZE)) {
                is Resource.Success -> {
                    endReached.value = currentPage * PAGE_SIZE >= result.data!!.count

                    val pokemonEntries = result.data.results.mapIndexed { index, entry ->
                        val number = if (entry.url.endsWith("/")) {
                            entry.url.dropLast(1).takeLastWhile {
                                it.isDigit()
                            }
                        } else {
                            entry.url.takeLastWhile {
                                it.isDigit()
                            }
                        }
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${number}.png"
                        PokemonListEntry(entry.name.capitalize(java.util.Locale.ROOT), url, number.toInt())

                    }
                    currentPage ++
                    loadError.value = ""
                    isLoading.value = false
                    pokemonList.value += pokemonEntries

                }

                is Resource.Error -> {
                    loadError.value = "Something went wrong."
                    isLoading.value = false

                }

                is Resource.Loading ->{}

            }
        }

    }

    fun calcDominateColor(drawable: Drawable, onFinish: (Color) -> Unit) {

        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bmp).generate { palette ->
            palette?.dominantSwatch?.rgb?.let { colorValue ->
                onFinish(Color(colorValue))
            }
        }

    }

}

