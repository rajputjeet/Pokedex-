package com.example.pokeDex.data.remote.responses

data class PokemonList(
    var count: Int,
    var next: String,
    var previous: Any,
    var results: List<Result>
)