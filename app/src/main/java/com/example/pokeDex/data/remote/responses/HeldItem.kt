package com.example.pokeDex.data.remote.responses

data class HeldItem(
    var item: com.example.pokeDex.data.remote.responses.Item,
    var version_details: List<com.example.pokeDex.data.remote.responses.VersionDetail>
)