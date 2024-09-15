package com.example.pokeDex.data.remote.responses

data class Ability(
    var ability: com.example.pokeDex.data.remote.responses.AbilityX,
    var is_hidden: Boolean,
    var slot: Int
)