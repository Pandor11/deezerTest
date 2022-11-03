package com.example.gradlekotlintest.data.local.room

import androidx.lifecycle.LiveData
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.rest.toPlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import kotlinx.coroutines.delay

class UserPlaylistsRoomDataSource(private val playlistDao: PlaylistDao) {

    fun getUserPlaylists(creatorId: Int): LiveData<List<PlaylistRoom>> =
        playlistDao.getUserPlaylists(creatorId)

    suspend fun saveUserPlaylists(list: List<PlaylistResponse>) {
        playlistDao.addPlaylists(list.map { it.toPlaylistRoom() })
    }

    suspend fun del(id: Int) = playlistDao.deletePlaylist(id)

}