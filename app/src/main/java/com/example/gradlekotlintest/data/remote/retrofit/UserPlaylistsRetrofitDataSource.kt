package com.example.gradlekotlintest.data.remote.retrofit

import com.example.gradlekotlintest.data.remote.PlaylistApi
import com.example.gradlekotlintest.data.remote.RestService
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.rest.UserPlaylistsResponse
import com.example.gradlekotlintest.domain.repositories.UserPlaylistsRemoteDataSource
import retrofit2.http.GET
import retrofit2.http.Path

class UserPlaylistsRetrofitDataSource(private val playlistApi: PlaylistApi) :
    UserPlaylistsRemoteDataSource {

    override suspend fun getUserPlaylists(userID: Int) = playlistApi.getUserPlaylists(userID)

}