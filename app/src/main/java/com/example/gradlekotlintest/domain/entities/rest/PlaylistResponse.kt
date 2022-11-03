package com.example.gradlekotlintest.domain.entities.rest

import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.utils.secondsIntoDate
import com.google.gson.annotations.SerializedName

data class PlaylistResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("picture") val picture: String,
    @SerializedName("creation_date") val creation_date: String,
    @SerializedName("creator") val creator: Creator,
    @SerializedName("type") val type: String,
    @SerializedName("tracks") val tracks: Tracks
)

data class Tracks(
    @SerializedName("data") val trackList: List<Datum>,
    @SerializedName("checksum") val checksum: String
)

data class Creator(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)

data class Datum(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("artist") val artist: Artist,
    @SerializedName("album") val album: Album
)

data class Artist(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String

)

data class Album(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("cover") val cover: String,
    @SerializedName("tracklist") val track_list: String

)

fun PlaylistResponse.toPlaylistRoom() = PlaylistRoom(
    playlistId = this.id,
    title = this.title,
    cover = this.picture,
    author = this.creator.name,
    duration = secondsIntoDate(this.duration.toBigDecimal()),
    creatorId = this.creator.id,
)