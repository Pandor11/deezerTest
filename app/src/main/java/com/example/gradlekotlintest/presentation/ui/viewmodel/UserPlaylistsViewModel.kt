package com.example.gradlekotlintest.presentation.ui.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.gradlekotlintest.domain.entities.dto.toPlaylist
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.usecase.LoadPlaylistUseCase
import com.example.gradlekotlintest.domain.usecase.LoadUserPlaylistsUseCase
import com.example.gradlekotlintest.presentation.adapters.PlaylistsRecyclerViewAdapter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.checkerframework.checker.units.qual.A
import javax.inject.Inject

class UserPlaylistsViewModel(
    private val creatorId: String,
    private val userPlaylistsUseCase: LoadUserPlaylistsUseCase
) : ViewModel() {
    val list: LiveData<List<PlaylistRoom>> =
        userPlaylistsUseCase.getPlaylistsLocal(creatorId.toInt())

    fun collectPlaylists(): Unit {
        viewModelScope.async {
            userPlaylistsUseCase.fetchPlaylists(creatorId.toInt())
        }
    }

    suspend fun deletePlaylist(id: Int) = userPlaylistsUseCase.del(id)


    class Factory @AssistedInject constructor(
        @Assisted("creatorId") val creatorId: String,
        private val userPlaylistUseCase: LoadUserPlaylistsUseCase,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserPlaylistsViewModel(creatorId, userPlaylistUseCase) as T
        }
    }

    @AssistedFactory
    interface FactoryAssisted {
        fun create(@Assisted("creatorId") creatorId: String): UserPlaylistsViewModel.Factory
    }
}