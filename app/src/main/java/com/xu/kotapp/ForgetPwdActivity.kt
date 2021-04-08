package com.xu.kotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xu.kotapp.databinding.ActivityForgetPwdBinding

class ForgetPwdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPwdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityForgetPwdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var tel = intent.getStringExtra("tel")

        if (!tel.isNullOrBlank()) {
            binding.textView2.text = tel
        }

    }
}