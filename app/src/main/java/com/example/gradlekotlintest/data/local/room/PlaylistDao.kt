package com.example.gradlekotlintest.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gradlekotlintest.domain.entities.room.PlaylistRoom
import com.example.gradlekotlintest.domain.entities.room.PlaylistTrackCrossRef
import com.example.gradlekotlintest.domain.entities.room.PlaylistWithTracks
import com.example.gradlekotlintest.domain.entities.room.TrackRoom
import kotlinx.coroutines.flow.Flow

@Dao
interface PlaylistDao {

    @Insert(entity = TrackRoom::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTracks(trackRoom: List<TrackRoom>)

    @Insert(entity = PlaylistTrackCrossRef::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTrackWithsPlaylist(playlistTrackCrossRef: List<PlaylistTrackCrossRef>)

    @Query("SELECT * FROM ${TrackRoom.TABLE_NAME} WHERE trackId == :trackId")
    suspend fun getTrack(trackId: Int): TrackRoom

    @Query("DELETE FROM ${PlaylistRoom.TABLE_NAME} WHERE playlistId == :id")
    suspend fun deletePlaylist(id: Int)



    @Insert(entity = PlaylistRoom::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlaylist(playlistRoom: PlaylistRoom)

    @Insert(entity = PlaylistRoom::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlaylists(playlistRoom: List<PlaylistRoom>)

    @Transaction
    @Query("SELECT * FROM ${PlaylistRoom.TABLE_NAME} WHERE playlistId == :playlistId")
    fun getPlaylist(playlistId: Int): LiveData<PlaylistWithTracks>

    @Query("SELECT * FROM ${PlaylistRoom.TABLE_NAME} WHERE creatorId == :creatorId")
    fun getUserPlaylists(creatorId: Int): LiveData<List<PlaylistRoom>>
}