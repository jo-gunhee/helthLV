package com.example.health_project.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FBRef {

    companion object {

        private val database = Firebase.database

        val category1 = database.getReference("contents")
        val category2 = database.getReference("contents2")


        val boardRef = database.getReference("board")

        val commentRef = database.getReference("comment")
        val nicknameRef = database.getReference("nickname")


    }


}