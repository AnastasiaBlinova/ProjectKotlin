package com.example.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.list.databinding.TaskItemBinding

class TaskItemAdapter(
    private  val taskItems: List<TaskItemBD>
): RecyclerView.Adapter<TaskItemVieHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemVieHolder {
       val from = LayoutInflater.from(parent.context)
        val binding = TaskItemBinding.inflate(from, parent, false)
        return  TaskItemVieHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: TaskItemVieHolder, position: Int) {
        holder.bindTaskItem(taskItems[position])
    }

    override fun getItemCount(): Int = taskItems.size
}