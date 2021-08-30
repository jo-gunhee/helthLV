package com.example.health_project.mission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.health_project.R
import android.content.Intent
import android.widget.Button
import com.example.health_project.MainActivity

class MissionSucces : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_succes)
        val btn11 = findViewById<Button>(R.id.btn11)
        btn11.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}