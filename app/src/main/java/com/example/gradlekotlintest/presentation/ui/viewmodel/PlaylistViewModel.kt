package com.example.gradlekotlintest.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.gradlekotlintest.domain.entities.dto.Playlist
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistWithTracks
import com.example.gradlekotlintest.domain.usecase.LoadPlaylistUseCase
import kotlinx.coroutines.launch

class PlaylistViewModel(
    private val loadPlaylistUseCase: LoadPlaylistUseCase,
    private val playlistId: String
) : ViewModel() {
    val playlist: LiveData<PlaylistWithTracks> =
        loadPlaylistUseCase.getPlaylistFromLocal(playlistId.toInt())

    fun getPlaylist() {
        viewModelScope.launch {
            loadPlaylistUseCase.savePlaylist(playlistId.toInt())
        }
    }

}