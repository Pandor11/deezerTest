package com.example.gradlekotlintest.domain.entities.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom.Companion.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class PlaylistRoom(
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int,
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
    @ColumnInfo(name = "trackList")
    val trackList: ArrayList<String> //TODO trackmodel
) {
    companion object {
const val TABLE_NAME = "playlist_entities_table"
    }
}