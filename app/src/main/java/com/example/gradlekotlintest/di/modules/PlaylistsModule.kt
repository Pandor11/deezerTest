package com.example.gradlekotlintest.di.modules

import com.example.gradlekotlintest.data.local.room.PlaylistDatabase
import com.example.gradlekotlintest.data.local.room.UserPlaylistsRoomDataSource
import com.example.gradlekotlintest.data.remote.PlaylistApi
import com.example.gradlekotlintest.data.remote.RestService
import com.example.gradlekotlintest.data.remote.retrofit.UserPlaylistsRetrofitDataSource
import com.example.gradlekotlintest.data.repositories.UserPlaylistsRepository
import com.example.gradlekotlintest.domain.usecase.LoadUserPlaylistsUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class PlaylistsModule {
    @Singleton
    @Provides
    fun provideLoadPlaylistsUseCase(playlistsRepository: UserPlaylistsRepository) =
        LoadUserPlaylistsUseCase(playlistsRepository)


    @Singleton
    @Provides
    fun providePlaylistsRepository(
        playlistsRoomDataSource: UserPlaylistsRoomDataSource,
        playlistsRetrofitService: UserPlaylistsRetrofitDataSource
    ) = UserPlaylistsRepository(playlistsRoomDataSource, playlistsRetrofitService)

    @Singleton
    @Provides
    fun provideUserPlaylistsRetrofitDataSource(playlistApi: PlaylistApi) =
        UserPlaylistsRetrofitDataSource(playlistApi)

    @Singleton
    @Provides
    fun provideRestService(retrofit: Retrofit): RestService =
        retrofit.create(RestService::class.java)


    @Singleton
    @Provides
    fun providePlaylistApi(restService: RestService) = PlaylistApi(restService)


    @Singleton
    @Provides
    fun providePlaylistsLocalDataSource(playlistDatabase: PlaylistDatabase) =
        UserPlaylistsRoomDataSource(playlistDatabase.playlistDao())

}