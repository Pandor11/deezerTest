package com.example.gradlekotlintest.di.components

import com.example.gradlekotlintest.di.modules.*
import com.example.gradlekotlintest.presentation.ui.fragments.FragmentPlaylist
import com.example.gradlekotlintest.presentation.ui.fragments.FragmentUserPlaylists
import com.example.gradlekotlintest.presentation.ui.viewmodel.UserPlaylistsViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [PlaylistsModule::class, PlaylistModule::class, ContextModule::class, RoomModule::class, NetworkModule::class])
interface PlaylistsComponent {

    fun inject(playlistFragment: FragmentPlaylist)

    fun inject(userPlaylistsFragment: FragmentUserPlaylists)

    fun inject(userPlaylistsViewModel: UserPlaylistsViewModel)

}