package com.example.gradlekotlintest.domain.repositories

import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import java.util.concurrent.Flow

interface PlaylistRemoteDataSource {
    suspend fun getPlaylist(playlistId : Int) : PlaylistResponse
}