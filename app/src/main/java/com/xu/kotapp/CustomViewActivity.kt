package com.xu.kotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xu.kotapp.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}