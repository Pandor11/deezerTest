package com.example.gradlekotlintest.common

import android.app.Application
import com.example.gradlekotlintest.di.modules.ContextModule
import com.example.gradlekotlintest.di.components.DaggerPlaylistsComponent
import com.example.gradlekotlintest.di.components.PlaylistsComponent

class App : Application() {
    lateinit var playlistComponent: PlaylistsComponent


    override fun onCreate() {
        super.onCreate()
        playlistComponent = DaggerPlaylistsComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()
    }
}