package com.example.ie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ie.databinding.ActivityInitBinding

class InitActivity : AppCompatActivity() {

    private lateinit var binding:ActivityInitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // initActivity를 터치하면 LogInActivity로 이동
        initActivityTouch()
    }

    private fun initActivityTouch() {
        binding.constLayoutInit.setOnClickListener{
            val intent = Intent(this@InitActivity, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}