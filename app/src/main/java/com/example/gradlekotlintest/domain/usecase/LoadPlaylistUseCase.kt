package com.example.gradlekotlintest.domain.usecase

import com.example.gradlekotlintest.data.repositories.PlaylistRepository

class LoadPlaylistUseCase(
    private val playlistRepo: PlaylistRepository
) {
    suspend fun savePlaylist(playlistId: Int) {
        val playlistResponse = playlistRepo.getPlaylist(playlistId)
        playlistRepo.savePlaylist(playlistResponse)
    }

    fun getPlaylistFromLocal(playlistId: Int) = playlistRepo.getPlaylistFromLocal(playlistId)

}
