package com.example.gradlekotlintest.data.remote

import com.example.gradlekotlintest.domain.entities.rest.UserPlaylistsResponse
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RestService {
    @GET("playlist/{id}")
    suspend fun getPlaylistInfo(@Path("id") playlistId: Int): PlaylistResponse

    @GET("user/{id}/playlists")
    suspend fun getUserPlaylists(@Path("id") userID: Int): UserPlaylistsResponse
}