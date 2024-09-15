package com.example.pokeDex.data.remote.responses

data class Pokemon(
    var abilities: List<com.example.pokeDex.data.remote.responses.Ability>,
    var base_experience: Int,
    var cries: com.example.pokeDex.data.remote.responses.Cries,
    var forms: List<com.example.pokeDex.data.remote.responses.Form>,
    var game_indices: List<com.example.pokeDex.data.remote.responses.GameIndice>,
    var height: Int,
    var held_items: List<com.example.pokeDex.data.remote.responses.HeldItem>,
    var id: Int,
    var is_default: Boolean,
    var location_area_encounters: String,
    var moves: List<com.example.pokeDex.data.remote.responses.Move>,
    var name: String,
    var order: Int,
    var past_abilities: List<Any>,
    var past_types: List<Any>,
    var species: com.example.pokeDex.data.remote.responses.Species,
    var sprites: com.example.pokeDex.data.remote.responses.Sprites,
    var stats: List<com.example.pokeDex.data.remote.responses.Stat>,
    var types: List<com.example.pokeDex.data.remote.responses.Type>,
    var weight: Int
)