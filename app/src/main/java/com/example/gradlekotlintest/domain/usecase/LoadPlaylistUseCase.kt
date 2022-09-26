package com.example.gradlekotlintest.domain.usecase

import com.example.gradlekotlintest.data.repositories.PlaylistRepository
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.rest.toPlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistWithTracks
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class LoadPlaylistUseCase(
    private val playlistRepo: PlaylistRepository,
    private val dispatcher: CoroutineDispatcher
) {

    fun fetchPlaylist(playlistId: Int) = flow {
        val playlist = playlistRepo.getPlaylistFromRemote(playlistId)
        emit(playlistRepo.getPlaylistFromLocal(playlistId))
        playlistRepo.savePlaylist(playlist)
        emit(playlistRepo.getPlaylistFromRemote(playlistId).toPlaylistRoom())
    }.flowOn(dispatcher)


}
