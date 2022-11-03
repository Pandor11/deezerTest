package com.example.gradlekotlintest.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.*
import androidx.databinding.Observable
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gradlekotlintest.databinding.PlaylistsItemBinding
import com.example.gradlekotlintest.databinding.TrackItemBinding
import com.example.gradlekotlintest.domain.entities.dto.Playlist
import com.example.gradlekotlintest.domain.entities.dto.Track
import java.util.*

class TrackRecyclerViewAdapter :
    RecyclerView.Adapter<TrackRecyclerViewAdapter.PlaylistViewHolder>() {
    val trackList = LinkedList<Track>()
    private val diffUtilCallback = DiffUtilCallback<Track>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = TrackItemBinding.inflate(inflater)
        return PlaylistViewHolder(binding, BR.track)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        holder.onBind(trackList[position])
    }

    override fun getItemCount() = trackList.size


    class PlaylistViewHolder(val binding: ViewDataBinding, val bindingVarId: Int) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Track) {
            binding.setVariable(bindingVarId, item)

            binding.executePendingBindings()
        }
    }


    companion object {
        @JvmStatic
        @BindingAdapter("android:src")
        fun loadImage(imageView: ImageView, v: String?) {
            Glide.with(imageView.context)
                .load(v)
                .into(imageView)
        }
    }


    private fun dispatchUpdates(newItems: List<Track>) =
        DiffUtil.calculateDiff(diffUtilCallback.update(newItems)).dispatchUpdatesTo(this)

    fun updateTracks(list: List<Track>) {
        trackList.clear()
        trackList.addAll(list)
        dispatchUpdates(trackList)
    }

}