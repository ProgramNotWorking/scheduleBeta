package com.example.recyclerviewforfutureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerviewforfutureapp.databinding.ActivityTuesdayBinding

class TuesdayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTuesdayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTuesdayBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}