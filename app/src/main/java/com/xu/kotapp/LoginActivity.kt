package com.xu.kotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xu.kotapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)


    }
}