package com.example.gradlekotlintest.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.gradlekotlintest.domain.entities.dto.Playlist
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.usecase.LoadPlaylistUseCase

class PlaylistViewModel(
    private val loadPlaylistUseCase: LoadPlaylistUseCase,
    private val playlistId: String
) : ViewModel() {
    val playlist: LiveData<Any> =
        loadPlaylistUseCase.fetchPlaylist(playlistId.toInt()).asLiveData()

}