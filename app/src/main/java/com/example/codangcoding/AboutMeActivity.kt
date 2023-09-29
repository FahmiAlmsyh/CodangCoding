package com.example.codangcoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codangcoding.databinding.ActivityDetailAboutBinding

class AboutMeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailAboutBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}