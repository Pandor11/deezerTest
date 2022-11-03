package com.example.gradlekotlintest.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gradlekotlintest.common.App
import com.example.gradlekotlintest.databinding.FragmentPlaylistBinding
import com.example.gradlekotlintest.domain.entities.dto.toPlaylist
import com.example.gradlekotlintest.domain.entities.dto.toTrack
import com.example.gradlekotlintest.domain.usecase.LoadPlaylistUseCase
import com.example.gradlekotlintest.presentation.adapters.TrackRecyclerViewAdapter
import com.example.gradlekotlintest.presentation.ui.fragments.FragmentUserPlaylists.Companion.EXTRA_PLAYLIST_ID
import com.example.gradlekotlintest.presentation.ui.viewmodel.PlaylistViewModel
import javax.inject.Inject

class FragmentPlaylist : Fragment() {

    @Inject
    lateinit var playlistUseCase: LoadPlaylistUseCase

    var binding: FragmentPlaylistBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlaylistBinding.inflate(inflater, container, false)
        this.binding = binding
        (requireActivity().application as App).playlistComponent.inject(this)

        val viewModel =
            PlaylistViewModel(playlistUseCase, requireArguments().getString(EXTRA_PLAYLIST_ID)!!)
        binding.adapter = TrackRecyclerViewAdapter()

        viewModel.playlist.observe(viewLifecycleOwner) { playlist ->
            binding.playlist = playlist.toPlaylist()
            binding.adapter!!.updateTracks(playlist.tracks.map { it.toTrack() })
        }
        viewModel.getPlaylist()

        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}