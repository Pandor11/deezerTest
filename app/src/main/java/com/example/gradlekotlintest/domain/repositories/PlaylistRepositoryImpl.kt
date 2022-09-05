package com.example.gradlekotlintest.domain.repositories

import com.example.gradlekotlintest.domain.entities.dto.Playlist

interface PlaylistRepositoryImpl {
    suspend fun loadPlaylist(playlistId: String): Playlist
}