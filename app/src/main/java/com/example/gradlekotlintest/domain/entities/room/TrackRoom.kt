package com.example.gradlekotlintest.domain.entities.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.gradlekotlintest.domain.entities.rest.Datum
import com.example.gradlekotlintest.domain.entities.room.TrackRoom.Companion.TABLE_NAME
import com.example.gradlekotlintest.utils.secondsIntoDate


@Entity(primaryKeys = ["trackId"], tableName = TABLE_NAME)
data class TrackRoom(
    @ColumnInfo(name = "trackId")
    val trackId: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "duration")
    val duration: String,
    @ColumnInfo(name = "artist")
    val artist: String,
    @ColumnInfo(name = "album")
    val album: String
) {
    companion object {
        const val TABLE_NAME = "track_entity_table"
    }
}

fun Datum.toTrackRoom() = TrackRoom(
    trackId = this.id,
    title = this.title,
    duration = secondsIntoDate(this.duration.toBigDecimal()),
    artist = this.artist.name,
    album = this.album.toString()
)

