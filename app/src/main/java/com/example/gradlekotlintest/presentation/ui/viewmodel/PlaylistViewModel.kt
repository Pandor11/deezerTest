package com.example.gradlekotlintest.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.gradlekotlintest.domain.usecase.LoadPlaylistUseCase

class PlaylistViewModel(
    private val loadPlaylistUseCase: LoadPlaylistUseCase,
    private val playlistId: String
) : ViewModel() {


}