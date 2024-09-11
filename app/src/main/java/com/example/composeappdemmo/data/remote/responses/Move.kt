package com.example.composeappdemmo.data.remote.responses

data class Move(
    var move: com.example.composeappdemmo.data.remote.responses.MoveX,
    var version_group_details: List<com.example.composeappdemmo.data.remote.responses.VersionGroupDetail>
)