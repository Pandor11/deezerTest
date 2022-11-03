package com.example.gradlekotlintest.data.repositories


import android.util.Log
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.repositories.PlaylistLocalDataSource
import com.example.gradlekotlintest.domain.repositories.PlaylistRemoteDataSource
import kotlin.math.log


class PlaylistRepository(
    private val playlistLocalDataSource: PlaylistLocalDataSource,
    private val remoteDataSource: PlaylistRemoteDataSource
) {
    suspend fun savePlaylist(playlistResponse: PlaylistResponse) {
        val tracks = playlistResponse.tracks.trackList
        val ids = ArrayList<Int>()
        tracks.forEach { ids.add(it.id) }
        playlistLocalDataSource.saveTracks(tracks)
        playlistLocalDataSource.saveCrossRef(ids, playlistResponse.id)
    }

    suspend fun getPlaylist(playlistId: Int) = remoteDataSource.getPlaylist(playlistId)

    fun getPlaylistFromLocal(playlistId: Int) =
        playlistLocalDataSource.getPlaylist(playlistId)
}

