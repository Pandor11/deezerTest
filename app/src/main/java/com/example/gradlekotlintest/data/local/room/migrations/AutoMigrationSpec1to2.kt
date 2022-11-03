package com.example.gradlekotlintest.data.local.room.migrations

import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.TrackRoom

@RenameColumn.Entries(
    value = [
        RenameColumn(
            tableName = PlaylistRoom.TABLE_NAME,
            fromColumnName = "id",
            toColumnName = "playlistId"
        ),
        RenameColumn(
            tableName = TrackRoom.TABLE_NAME,
            fromColumnName = "id",
            toColumnName = "trackId"
        )
    ]
)

class AutoMigrationSpec1to2 : AutoMigrationSpec
