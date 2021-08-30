package com.example.health_project.fragments

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.health_project.R
import com.example.health_project.databinding.FragmentHomeBinding
import com.example.health_project.databinding.FragmentMissionBinding
import com.example.health_project.mission.*
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView


class missionFragment : Fragment() {

    var materialCalendarView: MaterialCalendarView? = null
    var oneDayDecorator: OneDayDecorator = OneDayDecorator()
    private lateinit var binding : FragmentMissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setContentView(R.layout.activity_mission03)




    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d("HomeFragment", "onCreateView")
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_mission,container,false)
        materialCalendarView = binding.calendarView
        val va = materialCalendarView!!
        va.addDecorators(SundayDecorator(), SaturdayDecorator())
        va.addDecorators(oneDayDecorator)
        va.addDecorators(EventDecorator(Color.RED, setOf(CalendarDay.today())))

        binding.hometap.setOnClickListener {
            Log.d("HomeFragment", "tipTap")
            it.findNavController().navigate(R.id.action_missionFragment_to_homeFragment)
        }

        binding.communitytap.setOnClickListener {

            it.findNavController().navigate(R.id.action_missionFragment_to_communityFragment)

        }

        binding.settingtap.setOnClickListener {
            it.findNavController().navigate(R.id.action_missionFragment_to_settingFragment)
        }
        val btn01 = binding.btn03
        btn01.setOnClickListener {
            val intent = Intent(activity, MissionSucces::class.java)
            startActivity(intent)
        }


        return binding.root // 레이아웃 전개
    }


}