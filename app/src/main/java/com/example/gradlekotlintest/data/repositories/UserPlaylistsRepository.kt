package com.example.gradlekotlintest.data.repositories

import com.example.gradlekotlintest.data.local.room.UserPlaylistsRoomDataSource

import com.example.gradlekotlintest.data.remote.retrofit.UserPlaylistsRetrofitDataSource

import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse


class UserPlaylistsRepository(
    private val userPlaylistLocalDataSource: UserPlaylistsRoomDataSource,
    private val userPlaylistsRemoteDataSource: UserPlaylistsRetrofitDataSource
) {
    suspend fun savePlaylists(userPlaylistsResponse: List<PlaylistResponse>) =
        userPlaylistLocalDataSource.saveUserPlaylists(userPlaylistsResponse)

    suspend fun getPlaylistsFromRemote(creatorId: Int) =
        userPlaylistsRemoteDataSource.getUserPlaylists(creatorId)

    fun getPlaylistsFromLocal(creatorId: Int) =
        userPlaylistLocalDataSource.getUserPlaylists(creatorId)

  suspend  fun del(id:Int) = userPlaylistLocalDataSource.del(id)
}