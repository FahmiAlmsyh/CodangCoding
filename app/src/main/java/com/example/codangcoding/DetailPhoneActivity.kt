package com.example.codangcoding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.codangcoding.databinding.ActivityDetailPhoneBinding
import com.bumptech.glide.Glide
import com.example.codangcoding.model.dataPhone

class DetailPhoneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPhoneBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<dataPhone>("DATA")

        Glide.with(this)
            .load(data?.image)
            .into(binding.imageProfile)

        binding.tvName.text = data?.name
        binding.tvDescription.text = data?.detail
    }

}