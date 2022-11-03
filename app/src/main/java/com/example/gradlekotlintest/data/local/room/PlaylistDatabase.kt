package com.example.gradlekotlintest.data.local.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.gradlekotlintest.data.local.room.migrations.AutoMigrationSpec1to2
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistTrackCrossRef
import com.example.gradlekotlintest.domain.entities.room.TrackRoom


@Database(
    version = 4,
    entities = [PlaylistRoom::class, TrackRoom::class, PlaylistTrackCrossRef::class],
    autoMigrations = [
        AutoMigration(from = 1, to = 3, spec = AutoMigrationSpec1to2::class)],
    exportSchema = true
)

abstract class PlaylistDatabase : RoomDatabase() {
    abstract fun playlistDao(): PlaylistDao
}