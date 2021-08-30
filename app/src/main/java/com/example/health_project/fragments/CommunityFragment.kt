package com.example.health_project.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.health_project.R
import com.example.health_project.board.BoardListLVAdapter
import com.example.health_project.board.BoardModel
import com.example.health_project.board.BoardWriteActivity
import com.example.health_project.board.BoardinsideActivity
import com.example.health_project.databinding.FragmentCommunityBinding
import com.example.health_project.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class CommunityFragment : Fragment() {

    private lateinit var binding : FragmentCommunityBinding

    private var boardDataList = mutableListOf<BoardModel>()
    private var boardKeyList = mutableListOf<String>()

    private val TAG = CommunityFragment::class.java.simpleName

    private lateinit var boardRVAdapter : BoardListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_community, container, false)

        boardRVAdapter = BoardListLVAdapter(boardDataList)
        binding.boardListView.adapter = boardRVAdapter



        binding.boardListView.setOnItemClickListener { parent, view, position, id ->

            // 첫번째 방법으로는 listview에 있는 데이터 title content time 다 다른 액티비티로 전달해줘서 만들기
//            val intent = Intent(context, BoardInsideActivity::class.java)
//            intent.putExtra("title", boardDataList[position].title)
//            intent.putExtra("content", boardDataList[position].content)
//            intent.putExtra("time", boardDataList[position].time)
//            startActivity(intent)

            // 두번째 방법으로는 Firebase에 있는 board에 대한 데이터의 id를 기반으로 다시 데이터를 받아오는 방법
            val intent = Intent(context, BoardinsideActivity::class.java)
            intent.putExtra("key", boardKeyList[position])
            startActivity(intent)

        }





        binding.writeBtn.setOnClickListener {
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.hometap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_homeFragment)
        }

        binding.missiontap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_missionFragment)
        }

        binding.settingtap.setOnClickListener {
            it.findNavController().navigate(R.id.action_communityFragment_to_settingFragment)
        }


        getFBBoardData()

        return binding.root
    }

    private fun getFBBoardData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                boardDataList.clear()

                for (dataModel in dataSnapshot.children) {

                    Log.d(TAG, dataModel.toString())
//                    dataModel.key

                    val item = dataModel.getValue(BoardModel::class.java)
                    boardDataList.add(item!!)
                    boardKeyList.add(dataModel.key.toString())

                }
                boardKeyList.reverse()
                boardDataList.reverse()
                boardRVAdapter.notifyDataSetChanged()

                Log.d(TAG, boardDataList.toString())


            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardRef.addValueEventListener(postListener)

    }


}