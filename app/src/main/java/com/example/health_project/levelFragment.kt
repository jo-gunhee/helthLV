package com.example.health_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.health_project.databinding.FragmentHomeBinding
import com.example.health_project.databinding.FragmentLevelBinding


class levelFragment : Fragment() {

    private lateinit var binding : FragmentLevelBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFragment", "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_level, container, false)

        binding.levelup.setOnClickListener {
            it.findNavController().navigate(R.id.action_levelFragment_to_level2Fragment)
        }

        return binding.root
    }


}