package com.example.gradlekotlintest.presentation.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.gradlekotlintest.R
import com.example.gradlekotlintest.databinding.FragmentLoginBinding

class FragmentLogin() : Fragment(R.layout.fragment_login) {

    var binding: FragmentLoginBinding? = null
    var playlistId = "0"
    var userId = "0"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.etUserId?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                userId = binding!!.etUserId.text.toString()
            }
        })
        binding?.btnSearchUser?.setOnClickListener {
            findNavController().navigate(
                R.id.action_fragmentLogin_to_fragmentMain,
                bundleOf(USER_ID to userId)
            )
        }


    }

    companion object {
        const val USER_ID = "playlistId"
    }
}