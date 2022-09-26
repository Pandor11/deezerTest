package com.example.gradlekotlintest.data.repositories


import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.toTrackRoom
import com.example.gradlekotlintest.domain.repositories.PlaylistLocalDataSource
import com.example.gradlekotlintest.domain.repositories.PlaylistRemoteDataSource


class PlaylistRepository(
    private val playlistLocalDataSource: PlaylistLocalDataSource,
    private val remoteDataSource: PlaylistRemoteDataSource
) {
    suspend fun savePlaylist(playlistResponse: PlaylistResponse) {
        playlistResponse.tracks.trackList.forEach {
            playlistLocalDataSource.saveTrack(it)
        }
        playlistLocalDataSource.savePlaylist(playlistResponse)
    }

    suspend fun getPlaylistFromRemote(playlistId: Int) = remoteDataSource.getPlaylist(playlistId)

    suspend fun getPlaylistFromLocal(playlistId: Int) =
        playlistLocalDataSource.getPlaylist(playlistId)
}

