package com.example.recyclerviewforfutureapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewforfutureapp.databinding.LessonItemBinding

class MondayAdapter: RecyclerView.Adapter<MondayAdapter.MondayHolder>() {
    val lessonsList = ArrayList<Lesson>()

    class MondayHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = LessonItemBinding.bind(item)
        fun bind(lesson: Lesson) = with(binding) {
            val titleText = "${lesson.lessonNumber + 1} занятие"
            lessonNumberView.text = titleText
        }
    }

    fun onClickRemove(view: View): Boolean {
        return true
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MondayHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.lesson_item, parent, false
        )
        return MondayHolder(view)
    }

    override fun getItemCount(): Int {
        return lessonsList.size
    }

    override fun onBindViewHolder(holder: MondayHolder, position: Int) {
        holder.bind(lessonsList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addLesson(lesson: Lesson) {
        lessonsList.add(lesson)
        notifyDataSetChanged()
    }

    fun removeLesson() {
        lessonsList.removeAt(lessonsList.size - 1)
        notifyItemRemoved(lessonsList.size)
        notifyItemRangeChanged(lessonsList.size, lessonsList.size)
    }
}