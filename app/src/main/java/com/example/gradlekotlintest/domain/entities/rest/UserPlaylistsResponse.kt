package com.example.gradlekotlintest.domain.entities.rest

import com.google.gson.annotations.SerializedName

data class UserPlaylistsResponse(
    @SerializedName("data") val playlists: List<PlaylistResponse>,
    @SerializedName("checksum") val checksum: String,
    @SerializedName("total") val total: Int
)
