package com.xu.kotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xu.kotapp.databinding.ActivityMainBinding
import splitties.activities.start

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.hello.setOnClickListener { start<LoginActivity> { } }
    }
}

