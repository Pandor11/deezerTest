package com.example.gradlekotlintest.presentation.ui.fragments


import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gradlekotlintest.R
import com.example.gradlekotlintest.common.App
import com.example.gradlekotlintest.databinding.FragmentPlaylistsBinding
import com.example.gradlekotlintest.domain.entities.dto.toPlaylist
import com.example.gradlekotlintest.presentation.adapters.PlaylistsRecyclerViewAdapter
import com.example.gradlekotlintest.presentation.decorations.PlaylistDecorator
import com.example.gradlekotlintest.presentation.ui.fragments.FragmentLogin.Companion.USER_ID
import com.example.gradlekotlintest.presentation.ui.viewmodel.UserPlaylistsViewModel
import com.example.gradlekotlintest.utils.isNetworkAvailable
import com.example.gradlekotlintest.utils.toast
import javax.inject.Inject


class FragmentUserPlaylists : Fragment() {
    var binding: FragmentPlaylistsBinding? = null
    val adapter = PlaylistsRecyclerViewAdapter()


    @Inject
    lateinit var factory: UserPlaylistsViewModel.FactoryAssisted

    override fun onAttach(activity: Activity) {
        (requireActivity().application as App).playlistComponent.inject(this)
        super.onAttach(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPlaylistsBinding.inflate(inflater, container, false)
        this.binding = binding
        val mRecyclerView = binding.playlists
        mRecyclerView.addItemDecoration(PlaylistDecorator(R.layout.playlists_item, 24))
        mRecyclerView.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: UserPlaylistsViewModel by viewModels {
            factory.create(
                arguments?.get(
                    USER_ID
                ).toString()
            )
        }

        if (requireContext().isNetworkAvailable()) {
            viewModel.collectPlaylists()
        } else requireContext().toast("No internet connection")




        viewModel.list.observe(viewLifecycleOwner) { list ->
            adapter.setPlaylists(list.map { it.toPlaylist() })
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        const val EXTRA_PLAYLIST_ID = "EXTRA_PLAYLIST_ID"
    }
}