package com.example.recyclerviewforfutureapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewforfutureapp.databinding.ActivityMondayBinding

class MondayActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMondayBinding
    private val adapter = MondayAdapter()
    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMondayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MondayActivity, 1)
            rcView.adapter = adapter
        }

        binding.addButton.setOnClickListener {
            val lesson = Lesson(index)
            adapter.addLesson(lesson)
            index++
        }

        binding.backButton.setOnClickListener {
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
}