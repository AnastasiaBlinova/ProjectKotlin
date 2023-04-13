package com.example.list

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.TaskItemBinding

class TaskItemVieHolder(
    private val context: Context,
    private val binding: TaskItemBinding
): RecyclerView.ViewHolder(binding.root){
    fun bindTaskItem(taskItem: TaskItemBD){

        binding.nameInit.text = taskItem.name
    }
}