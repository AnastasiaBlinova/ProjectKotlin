package com.example.todolist

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.TaskItemBinding

class TaskItemViewHolder(
    private val context: Context,
    private val binding: TaskItemBinding
): RecyclerView.ViewHolder(binding.root) {//держатель вида элементов задач
    fun bindingTaskItem(taskItemBD: TaskItemBD){
        binding.nameInit.text = taskItemBD.name

    }
}