package com.example.gradlekotlintest.domain.repositories

import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.rest.UserPlaylistsResponse
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom

interface UserPlaylistLocalDataSource {

    suspend fun saveUserPlaylists(userPlaylistsResponse: List<PlaylistResponse>)
    suspend fun getUserPlaylists(creatorId: Int): List<PlaylistRoom>
}