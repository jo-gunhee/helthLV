package com.example.health_project.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.health_project.R
import com.example.health_project.databinding.FragmentSettingBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class settingFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentSettingBinding
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        // Inflate the layout for this fragment


        binding.hometap.setOnClickListener {
            Log.d("HomeFragment", "tipTap")
            it.findNavController().navigate(R.id.action_settingFragment_to_homeFragment)
        }

        binding.missiontap.setOnClickListener {

            it.findNavController().navigate(R.id.action_settingFragment_to_missionFragment)

        }

        binding.communitytap.setOnClickListener {
            it.findNavController().navigate(R.id.action_settingFragment_to_communityFragment)
        }
        //gps
        binding.buttonGps.setOnClickListener{

            //mMap.animateCamera(CameraUpdateFactory)

        }
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



        return binding.root


    }

    override fun onMapReady(googleMap : GoogleMap) {
        mMap = googleMap
        val marker = LatLng(37.33339, 127.8888)
        mMap.addMarker(MarkerOptions().position(marker).title("Marker LAB"))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(marker, 15F))
    }

}