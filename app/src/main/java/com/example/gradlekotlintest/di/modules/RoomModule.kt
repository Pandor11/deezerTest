package com.example.gradlekotlintest.di.modules

import android.content.Context
import androidx.room.Room
import com.example.gradlekotlintest.data.local.room.PlaylistDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context) =
        Room.databaseBuilder(
            context,
            PlaylistDatabase::class.java,
            "playlist_room_database"
        )

    @Singleton
    @Provides
    fun provideRoom(context: Context) =
        Room.databaseBuilder(
            context, PlaylistDatabase::class.java, "playlists_data_base")
            .fallbackToDestructiveMigration()
            .build()

}