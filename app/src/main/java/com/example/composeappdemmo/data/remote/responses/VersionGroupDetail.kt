package com.example.composeappdemmo.data.remote.responses

data class VersionGroupDetail(
    var level_learned_at: Int,
    var move_learn_method: com.example.composeappdemmo.data.remote.responses.MoveLearnMethod,
    var version_group: com.example.composeappdemmo.data.remote.responses.VersionGroup
)