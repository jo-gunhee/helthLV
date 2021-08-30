package com.example.health_project.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.health_project.R
import com.example.health_project.board.BoardWriteActivity
import com.example.health_project.databinding.FragmentHomeBinding
import com.example.health_project.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class HomeFragment : Fragment() {


    private lateinit var binding : FragmentHomeBinding

    private val TAG = HomeFragment::class.java.simpleName

    val bookmarkIdList = mutableListOf<String>()
    val itemKeyList = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("HomeFragment", "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.levelup.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_levelFragment)
        }



        binding.missiontap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_missionFragment)
        }

        binding.communitytap.setOnClickListener {

            it.findNavController().navigate(R.id.action_homeFragment_to_communityFragment)

        }

        binding.settingtap.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_settingFragment)
        }

        getCategoryData()

        return binding.root
    }

    private fun getCategoryData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.category1.addValueEventListener(postListener)
        FBRef.category2.addValueEventListener(postListener)

    }


}