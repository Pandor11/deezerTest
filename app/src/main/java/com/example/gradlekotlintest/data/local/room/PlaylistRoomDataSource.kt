package com.example.gradlekotlintest.data.local.room

import com.example.gradlekotlintest.domain.entities.rest.Datum
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.rest.toPlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistTrackCrossRef
import com.example.gradlekotlintest.domain.entities.room.toTrackRoom
import com.example.gradlekotlintest.domain.repositories.PlaylistLocalDataSource

class PlaylistRoomDataSource(private val playlistDao: PlaylistDao) : PlaylistLocalDataSource {
    override fun getPlaylist(playlistId: Int) = playlistDao.getPlaylist(playlistId)

    override suspend fun savePlaylist(playlistResponse: PlaylistResponse) {
        playlistDao.addPlaylist(playlistResponse.toPlaylistRoom())
    }


    override suspend fun saveTracks(datum: List<Datum>) {
        playlistDao.addTracks(datum.map { it.toTrackRoom() })

    }

    override suspend fun saveCrossRef(trackIds: List<Int>, playlistId: Int) {
        val list = ArrayList<PlaylistTrackCrossRef>()
        trackIds.forEach { list.add(PlaylistTrackCrossRef(playlistId, it)) }
        playlistDao.addTrackWithsPlaylist(list)
    }


}