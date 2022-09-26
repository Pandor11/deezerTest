package com.example.gradlekotlintest.domain.entities.room

import androidx.room.*
import com.example.gradlekotlintest.data.local.room.TrackTypeConverter
import com.example.gradlekotlintest.domain.entities.dto.Playlist
import com.example.gradlekotlintest.domain.entities.rest.PlaylistResponse
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom.Companion.TABLE_NAME


@Entity(primaryKeys = ["playlistId", "creatorId"], tableName = TABLE_NAME)
data class PlaylistRoom(
    @ColumnInfo(name = "playlistId")
    val playlistId: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "cover")
    val cover: String,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "duration")
    val duration: String,
    @ColumnInfo(name = "creatorId")
    val creatorId: Int,

) {
    companion object {
        const val TABLE_NAME = "playlist_entities_table"
    }
}

@Entity(primaryKeys = ["playlistId", "trackId"], tableName = "cross_table")
data class PlaylistTrackCrossRef(
    val playlistId: Int,
    val trackId: Int
)

data class PlaylistWithTracks(
    @Embedded val playlist: PlaylistRoom,
    @Relation(
        parentColumn = "playlistId",
        entityColumn = "trackId",
        associateBy = Junction(PlaylistTrackCrossRef::class)
    ) val tracks: List<TrackRoom>
)

