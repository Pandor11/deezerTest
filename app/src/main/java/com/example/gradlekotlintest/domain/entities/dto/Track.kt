package com.example.gradlekotlintest.domain.entities.dto

import com.example.gradlekotlintest.domain.entities.room.TrackRoom
import com.example.gradlekotlintest.presentation.adapters.IRecyclerItemViewModel

data class Track(
    override val id: Int,
    val title: String,
    val duration: String,
    val artist: String,

) : IRecyclerItemViewModel {
    val fullName : String = "$title $artist $duration"
    override fun toString(): String = "$id $title $duration $artist"

}

fun TrackRoom.toTrack() =
    Track(
        id = this.trackId,
        title = this.title,
        duration = this.duration.toString(),
        artist = this.artist
    )