package com.example.pokeDex.data.remote.responses

data class Stat(
    var base_stat: Int,
    var effort: Int,
    var stat: com.example.pokeDex.data.remote.responses.StatX
)