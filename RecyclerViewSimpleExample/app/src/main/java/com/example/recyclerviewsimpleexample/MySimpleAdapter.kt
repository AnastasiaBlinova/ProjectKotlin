package com.example.recyclerviewsimpleexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewsimpleexample.databinding.MySimpleListItemBinding

class MySimpleAdapter(
    private val values: List<String>
) : RecyclerView.Adapter<MySimpleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MySimpleViewHolder {
        val binding = MySimpleListItemBinding.inflate(LayoutInflater.from(parent.context))
        return MySimpleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MySimpleViewHolder, position: Int) {
        val item = values[position]
        holder.binding.testFirld.text = item
    }

    override fun getItemCount(): Int = values.size
}

class MySimpleViewHolder(val binding: MySimpleListItemBinding):
    RecyclerView.ViewHolder(binding.root)











