package com.example.gradlekotlintest.domain.entities.dto


data class Playlist(
    val id: Int,
    val title: String,
    val cover: String,
    val author: String,
    val duration: String,
    val creatorId: Int,
    val trackList: ArrayList<String> //TODO trackmodel
)

