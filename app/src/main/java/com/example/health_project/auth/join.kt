package com.example.health_project.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.health_project.MainActivity
import com.example.health_project.R
import com.example.health_project.databinding.ActivityJoinBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class join : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_join)
        auth = Firebase.auth

        binding.NewBtn.setOnClickListener {

            var GotoJoin = true

            val email = binding.emailArea.text.toString()
            val password1 = binding.passwordArea1.text.toString()
            val password2 = binding.passwordArea2.text.toString()
            val nickname = binding.NicknameArea.text.toString()

            //값이 비어있는지 확인
            if (email.isEmpty()) {
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_LONG).show()
                GotoJoin = false
            }
            if (nickname.isEmpty()) {
                Toast.makeText(this, "닉네임을 입력해주세요", Toast.LENGTH_LONG).show()
                GotoJoin = false
            }
            if (password1.isEmpty()) {
                Toast.makeText(this, "패스워드를 입력해주세요", Toast.LENGTH_LONG).show()
                GotoJoin = false
            }
            if (password2.isEmpty()) {
                Toast.makeText(this, "패스워드 확인을 입력해주세요", Toast.LENGTH_LONG).show()
                GotoJoin = false
            }
            //비밀번호 2개가 같은지 확인
            if (!password1.equals(password2)) {
                Toast.makeText(this, "패스워드를 똑같이 입력해주세요", Toast.LENGTH_LONG).show()
                GotoJoin = false
            }
            //비밀번호가 10자리 이상인지 확인
            if (password1.length < 10) {
                Toast.makeText(this, " 최소 10자리 이상 입력해주세요", Toast.LENGTH_LONG).show()
                GotoJoin = false
            }

            if (GotoJoin){
                auth.createUserWithEmailAndPassword(email, password1)
                    .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "회원가입되었습니다", Toast.LENGTH_LONG).show()

                        val intent = Intent(this, MainActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "email이나 password가 맞지않습니다", Toast.LENGTH_LONG).show()
                    }
                }

                }
            }
    }







}