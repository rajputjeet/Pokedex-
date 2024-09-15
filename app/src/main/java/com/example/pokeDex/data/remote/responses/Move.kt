package com.example.pokeDex.data.remote.responses

data class Move(
    var move: com.example.pokeDex.data.remote.responses.MoveX,
    var version_group_details: List<com.example.pokeDex.data.remote.responses.VersionGroupDetail>
)