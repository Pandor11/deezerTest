package com.example.gradlekotlintest.domain.usecase

import android.util.Log
import com.example.gradlekotlintest.data.repositories.UserPlaylistsRepository
import com.example.gradlekotlintest.domain.entities.rest.toPlaylistRoom
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoadUserPlaylistsUseCase
    (
    private val playlistRepo: UserPlaylistsRepository,
) {

    fun getPlaylistsLocal(creatorID: Int) = playlistRepo.getPlaylistsFromLocal(creatorID)


    suspend fun fetchPlaylists(creatorID: Int) {
        try {
            playlistRepo.savePlaylists(playlistRepo.getPlaylistsFromRemote(creatorID))
        } catch (e: Exception) {
            throw e

        }

    }

    suspend fun del(id: Int) = playlistRepo.del(id)
}
