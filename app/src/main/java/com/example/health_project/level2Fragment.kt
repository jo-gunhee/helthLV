package com.example.health_project

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.health_project.databinding.FragmentLevel2Binding
import com.example.health_project.databinding.FragmentLevelBinding


class level2Fragment : Fragment() {

    private lateinit var binding : FragmentLevel2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("HomeFragment", "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_level2, container, false)

        binding.missiontap.setOnClickListener {
            it.findNavController().navigate(R.id.action_level2Fragment_to_missionFragment)
        }
        binding.communitytap.setOnClickListener {
            it.findNavController().navigate(R.id.action_level2Fragment_to_communityFragment)
        }
        binding.settingtap.setOnClickListener {
            it.findNavController().navigate(R.id.action_level2Fragment_to_settingFragment)
        }

        return binding.root
    }
}