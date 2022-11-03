package com.example.gradlekotlintest.di.modules

import android.content.Context
import androidx.room.Room
import com.example.gradlekotlintest.data.repositories.PlaylistRepository
import com.example.gradlekotlintest.data.local.room.PlaylistDatabase
import com.example.gradlekotlintest.data.local.room.PlaylistRoomDataSource
import com.example.gradlekotlintest.data.remote.PlaylistApi
import com.example.gradlekotlintest.data.remote.retrofit.PlaylistRetrofitDataSource
import com.example.gradlekotlintest.domain.usecase.LoadPlaylistUseCase
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class PlaylistModule {

    @Singleton
    @Provides
    fun provideLoadPlaylistUseCase(playlistRepository: PlaylistRepository): LoadPlaylistUseCase =
        LoadPlaylistUseCase(playlistRepository)


    @Singleton
    @Provides
    fun providePlaylistRepository(
        playlistRoomDataSource: PlaylistRoomDataSource,
        playlistRetrofitService: PlaylistRetrofitDataSource
    ) = PlaylistRepository(playlistRoomDataSource, playlistRetrofitService)


    @Singleton
    @Provides
    fun providePlaylistLocalDataSource(playlistDatabase: PlaylistDatabase): PlaylistRoomDataSource =
        PlaylistRoomDataSource(playlistDatabase.playlistDao())


    @Singleton
    @Provides
    fun provideUserPlaylistsRetrofitDataSource(playlistApi: PlaylistApi) =
        PlaylistRetrofitDataSource(playlistApi)


}