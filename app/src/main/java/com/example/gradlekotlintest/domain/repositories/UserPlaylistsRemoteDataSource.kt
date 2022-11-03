package com.example.gradlekotlintest.domain.repositories

import com.example.gradlekotlintest.data.remote.RestService
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.rest.UserPlaylistsResponse

interface UserPlaylistsRemoteDataSource {
     suspend fun getUserPlaylists(userID: Int): List<PlaylistResponse>
}