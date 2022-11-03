package com.example.gradlekotlintest.data.remote

import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import retrofit2.Retrofit

class PlaylistApi(private val restService: RestService) {

    suspend fun getPlaylist(playlistId: Int) = restService.getPlaylistInfo(playlistId)


    suspend fun getUserPlaylists(creatorId: Int): List<PlaylistResponse> =
        restService.getUserPlaylists(creatorId).playlists

}