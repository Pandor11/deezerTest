package com.example.gradlekotlintest.domain.repositories

import androidx.lifecycle.LiveData
import com.example.gradlekotlintest.domain.entities.rest.Datum
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistWithTracks

interface PlaylistLocalDataSource {
    fun getPlaylist(playlistId: Int): LiveData<PlaylistWithTracks>
    suspend fun savePlaylist(playlistResponse: PlaylistResponse)
    suspend fun saveTracks(datum: List<Datum>)
    suspend fun saveCrossRef(trackIds: List<Int>, playlistId: Int)
}