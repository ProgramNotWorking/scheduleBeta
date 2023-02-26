package com.example.recyclerviewforfutureapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.recyclerviewforfutureapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var mondayLauncher: ActivityResultLauncher<Intent>? = null
    private var tuesdayLauncher: ActivityResultLauncher<Intent>? = null
    private var wednesdayLauncher: ActivityResultLauncher<Intent>? = null
    private var thursdayLauncher: ActivityResultLauncher<Intent>? = null
    private var fridayLauncher: ActivityResultLauncher<Intent>? = null
    private var saturdayLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mondayButton.setOnClickListener {
            mondayLauncher?.launch(Intent(this, MondayActivity::class.java))
        }

        mondayLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                // TODO get some lists with students with Extras
            }
        }

        binding.tuesdayButton.setOnClickListener {
            tuesdayLauncher?.launch(Intent(this, TuesdayActivity::class.java))
        }

        // TODO: another activity
    }
}