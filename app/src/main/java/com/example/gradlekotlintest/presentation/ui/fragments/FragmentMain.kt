package com.example.gradlekotlintest.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.gradlekotlintest.R
import com.example.gradlekotlintest.presentation.ui.fragments.FragmentLogin.Companion.USER_ID
import com.google.android.material.bottomnavigation.BottomNavigationView

class FragmentMain : Fragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView =
            view.findViewById<BottomNavigationView>(R.id.mainBottomNavigationView)
        val navController =
            (childFragmentManager.findFragmentById(R.id.mainContainerView) as NavHostFragment)
                .navController
        bottomNavigationView.setupWithNavController(navController)

        navController.setGraph(
            R.navigation.nav_graph_main, bundleOf(
                USER_ID to arguments?.get(
                    USER_ID
                )
            )
        )

    }

}