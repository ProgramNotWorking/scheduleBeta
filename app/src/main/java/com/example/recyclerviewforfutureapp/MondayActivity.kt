package com.example.recyclerviewforfutureapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewforfutureapp.databinding.ActivityMondayBinding

class MondayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMondayBinding
    private val adapter = MondayAdapter()
    private var index: Int = 0

    private val fileName = "monday.txt"
    private lateinit var namesList: ArrayList<String>
    private lateinit var timeList: ArrayList<Int>

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMondayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MondayActivity, 1)
            rcView.adapter = adapter
        }

        binding.addButton.setOnClickListener {
            val lesson = Lesson(
                index, StringsConstances.ENTER_NAME, StringsConstances.ENTER_TIME.toInt()
            )
            adapter.addLesson(lesson)
            index++
        }

        binding.backButton.setOnClickListener {
            Log.d("Test log name:", adapter.lessonsList[0].studentName)
            Log.d("Test log name:", adapter.lessonsList[0].lessonTime.toString())

            val intent = Intent()
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.removeButton.setOnClickListener {
            if (adapter.lessonsList.size != 0) {
                adapter.removeLesson()
                index -= 1
            }
        }
    }

    override fun onPause() {
        super.onPause()
    }
}