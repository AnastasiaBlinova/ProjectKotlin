package com.example.m18_permissions

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m18_permissions.databinding.ItemPhotoBinding

class Adapter (

): RecyclerView.Adapter<PhotoViewHolder>() {

    private var valuesBd: List<PhotosOfSights> = emptyList()

    fun setData(newData: List<PhotosOfSights>){
        this.valuesBd = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        Log.e("СТАРТ","onCreateViewHolder")
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context))
        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        Log.e("СТАРТ","onBindViewHolder")
        holder.viewItem(valuesBd[position])
    }

    override fun getItemCount(): Int = valuesBd.size
}

class PhotoViewHolder (
    val binding: ItemPhotoBinding
): RecyclerView.ViewHolder(binding.root){

    fun viewItem (photosOfSights: PhotosOfSights){
        Log.e("СТАРТ","viewItem (дата ${photosOfSights.data} фото ${photosOfSights.photo}")
        binding.data.text = photosOfSights.data
        Glide.with(binding.itemPhoto)
            .load(photosOfSights.photo)
            .into(binding.itemPhoto)
    }

}
