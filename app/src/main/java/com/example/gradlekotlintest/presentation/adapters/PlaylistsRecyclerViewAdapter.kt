package com.example.gradlekotlintest.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gradlekotlintest.R
import com.example.gradlekotlintest.domain.entities.dto.Playlist
import com.example.gradlekotlintest.presentation.ui.fragments.FragmentUserPlaylists.Companion.EXTRA_PLAYLIST_ID
import kotlin.collections.ArrayList

class PlaylistsRecyclerViewAdapter :
    RecyclerView.Adapter<PlaylistsRecyclerViewAdapter.PlaylistViewHolder>() {

    private val playlists: MutableList<Playlist> = ArrayList()
    private val diffUtilCallback = DiffUtilCallback<Playlist>()

    class PlaylistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentId = ""
        private val cover: ImageView = itemView.findViewById(R.id.playlist_cover)
        private val title: TextView = itemView.findViewById(R.id.playlist_title)
        fun bind(playlist: Playlist) {
            currentId = playlist.id.toString()
            Glide.with(cover.context)
                .load(playlist.cover)
                .into(cover)
            title.text = playlist.title
        }

    }

    override fun getItemViewType(position: Int) = R.layout.playlists_item


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val vh = PlaylistViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.playlists_item, parent, false)
        )
        vh.itemView.setOnClickListener {

            it.findNavController().navigate(
                R.id.action_fragmentUserPlaylists_to_fragmentPlaylist,
                bundleOf(EXTRA_PLAYLIST_ID to vh.currentId)
            )
        }

        return vh
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = playlists[position]
        holder.bind(playlist)
    }

    override fun getItemCount() = playlists.size


    fun setPlaylists(list: List<Playlist>) {
        playlists.clear()
        playlists.addAll(list)
        DiffUtil.calculateDiff(diffUtilCallback.update(list)).dispatchUpdatesTo(this)
    }


}