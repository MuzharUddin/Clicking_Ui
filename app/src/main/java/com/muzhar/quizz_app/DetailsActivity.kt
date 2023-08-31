package com.muzhar.quizz_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muzhar.quizz_app.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
   private lateinit var binding: ActivityDetailsBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailsBinding.inflate(layoutInflater)
        var myintent = intent


        setContentView(binding.root)

        binding.name.text=myintent.getStringExtra("name")
        binding.bmbo.text=myintent.getStringExtra("bm")
        binding.payment.text=myintent.getStringExtra("pmnt")
    }
}