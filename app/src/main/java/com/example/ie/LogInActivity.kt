package com.example.ie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.ie.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 회원가입 버튼 눌렀을 때, 호출되는 함수
        signUpButtonStartClickEvent()

        // 로그인 버튼 눌렀을 때, 호출되는 함수
        logInButtonClickEvent()
    }

    // 회원가입 버튼 누르면 회원가입 페이지로 이동
    private fun signUpButtonStartClickEvent() {
        binding.buttonSignUpStart.setOnClickListener{
            val intent = Intent(this@LogInActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    // 로그인 버튼 눌렀을 때
    private fun logInButtonClickEvent() {
        binding.buttonLogIn.setOnClickListener {
            var signInID = binding.etLogInIdInput.text
            var signInPassword = binding.etLogInPasswordInput.text

            // ID나 Password 둘 중 하나라도 입력하지 않은 경우, "아이디/비밀번호를 확인해주세요!"라는 토스트 메시지 띄움
            if (signInID.isNullOrBlank() || signInPassword.isNullOrBlank()) {
                Toast.makeText(
                    this@LogInActivity,
                    "아이디/비밀번호를 확인해주세요!",
                    Toast.LENGTH_SHORT
                ).show()
            } else { // ID나 Password 모두 입력한 경우, "로그인 성공!"이라는 토스트 메시지 띄우고 MainActivity로 이동
                Toast.makeText(
                    this@LogInActivity,
                    "로그인 성공!",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this@LogInActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}