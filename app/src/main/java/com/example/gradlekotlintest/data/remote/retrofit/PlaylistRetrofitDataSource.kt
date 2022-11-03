package com.example.gradlekotlintest.data.remote.retrofit

import com.example.gradlekotlintest.data.remote.PlaylistApi
import com.example.gradlekotlintest.data.remote.RestService
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.rest.UserPlaylistsResponse
import com.example.gradlekotlintest.domain.repositories.PlaylistRemoteDataSource

class PlaylistRetrofitDataSource(private val playlistApi: PlaylistApi) : PlaylistRemoteDataSource {

    override suspend fun getPlaylist(playlistId: Int) = playlistApi.getPlaylist(playlistId)
}

