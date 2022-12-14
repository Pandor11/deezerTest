package com.example.gradlekotlintest.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gradlekotlintest.R

class FragmentSplash : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.postDelayed({
                         findNavController().navigate(R.id.action_fragmentSplash_to_fragmentLogin)
        }, 2222)
    }
}