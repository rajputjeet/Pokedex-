package com.example.composeappdemmo.data.remote.responses

data class Sprites(
    var back_default: String,
    var back_female: Any,
    var back_shiny: String,
    var back_shiny_female: Any,
    var front_default: String,
    var front_female: Any,
    var front_shiny: String,
    var front_shiny_female: Any,
    var other: com.example.composeappdemmo.data.remote.responses.Other,
    var versions: com.example.composeappdemmo.data.remote.responses.Versions
)