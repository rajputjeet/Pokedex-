package com.example.composeappdemmo.data.remote.responses

data class HeldItem(
    var item: com.example.composeappdemmo.data.remote.responses.Item,
    var version_details: List<com.example.composeappdemmo.data.remote.responses.VersionDetail>
)