package com.example.list

import android.content.Context
import android.graphics.Paint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.TaskItemBinding
import java.time.format.DateTimeFormatter

class TaskItemVieHolder(
    private val context: Context,
    private val binding: TaskItemBinding,
    private val clickListener: TaskItemClickListener
): RecyclerView.ViewHolder(binding.root){
    @RequiresApi(Build.VERSION_CODES.O)
    val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    @RequiresApi(Build.VERSION_CODES.O)
    fun bindTaskItem(taskItem: TaskItemBD){

        binding.nameInit.text = taskItem.name

        if (taskItem.isCompleted()){
            binding.nameInit.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.timeInit.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        binding.completeButton.setOnClickListener {
            clickListener.completeTaskItem(taskItem)
        }
        binding.taskContainer.setOnClickListener {
            clickListener.editTaskItem(taskItem)
        }

        if (taskItem.dueTime != null)
            binding.timeInit.text = timeFormat.format(taskItem.dueTime)
        else
            binding.timeInit.text = ""
    }
}