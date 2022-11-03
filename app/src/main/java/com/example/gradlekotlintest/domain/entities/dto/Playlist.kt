package com.example.gradlekotlintest.domain.entities.dto

import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistWithTracks
import com.example.gradlekotlintest.presentation.adapters.IRecyclerItemViewModel
import com.example.gradlekotlintest.utils.secondsIntoDate


data class Playlist (
    override val id: Int,
    val title: String,
    val cover: String,
    val author: String,
    val duration: String,
    val creatorId: Int,
    val trackList: List<Track>?
): IRecyclerItemViewModel

fun PlaylistWithTracks.toPlaylist() = Playlist(
    id = this.playlist.playlistId,
    title = this.playlist.title,
    cover = this.playlist.cover,
    author = this.playlist.author,
    duration = this.playlist.duration,
    creatorId = this.playlist.creatorId,
    trackList = this.tracks.map { it.toTrack() }
)

fun PlaylistRoom.toPlaylist() = Playlist(
    id = this.playlistId,
    title = this.title,
    cover = this.cover,
    author = this.author,
    duration = this.duration,
    creatorId = this.creatorId,
    trackList = null
)




