package com.example.gradlekotlintest.domain.usecase

import com.example.gradlekotlintest.domain.entities.dto.Playlist
import com.example.gradlekotlintest.data.repositories.PlaylistRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LoadPlaylistUseCase(
    private val playlistRepo: PlaylistRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun LoadPlaylist(playlistId: String): Playlist {
        return withContext(dispatcher) {
            val playlist = playlistRepo.loadPlaylist(playlistId)
            return@withContext playlist

        }
    }
}