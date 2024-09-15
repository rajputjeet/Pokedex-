package com.example.pokeDex.data.remote.responses

data class VersionGroupDetail(
    var level_learned_at: Int,
    var move_learn_method: com.example.pokeDex.data.remote.responses.MoveLearnMethod,
    var version_group: com.example.pokeDex.data.remote.responses.VersionGroup
)