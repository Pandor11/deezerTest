package com.example.gradlekotlintest.data.repositories

import com.example.gradlekotlintest.domain.entities.dto.Playlist
import com.example.gradlekotlintest.domain.repositories.PlaylistRepositoryImpl

class PlaylistRepository(private val playlistRetrofitService: PlaylistRetrofitService) : PlaylistRepositoryImpl{
    override suspend fun loadPlaylist(playlistId: String): Playlist {
        playlistRetrofitService.getPlaylist(playlistId)
    }
}