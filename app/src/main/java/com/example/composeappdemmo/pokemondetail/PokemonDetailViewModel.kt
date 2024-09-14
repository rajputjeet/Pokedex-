package com.example.composeappdemmo.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.composeappdemmo.data.remote.responses.Pokemon
import com.example.composeappdemmo.repository.PokemonRepository
import com.example.composeappdemmo.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel() {

        suspend fun getPokemonDetails(pokemonName: String): Resource<Pokemon> {
           return repository.getPokemonInfo(pokemonName)
        }

}
