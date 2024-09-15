package com.example.pokeDex.pokemondetail

import androidx.lifecycle.ViewModel
import com.example.pokeDex.data.remote.responses.Pokemon
import com.example.pokeDex.repository.PokemonRepository
import com.example.pokeDex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel() {

        suspend fun getPokemonDetails(pokemonName: String): Resource<Pokemon> {
           return repository.getPokemonInfo(pokemonName)
        }

}
