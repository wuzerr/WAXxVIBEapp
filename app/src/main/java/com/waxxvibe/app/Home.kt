package com.waxxvibe.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.waxxvibe.app.databinding.HomeBinding
import android.content.Intent

class Home : Fragment() {

    private lateinit var binding: HomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = HomeBinding.inflate(inflater, container, false)
        configureButtons()
        return binding.root
    }

    private fun configureButtons() {
        with(binding) {
            buttonbraz.setOnClickListener {
                val intent = Intent(requireContext(), BrazOnly::class.java)
                startActivity(intent)
            }
            buttontbrazaddon.setOnClickListener {
                val intent = Intent(requireContext(), BrazPlusAddOn::class.java)
                startActivity(intent)
        }
    }
}}
