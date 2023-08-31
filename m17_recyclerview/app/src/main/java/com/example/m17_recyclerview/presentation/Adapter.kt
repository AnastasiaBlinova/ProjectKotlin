package com.example.m17_recyclerview.sputnik_photo_list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m17_recyclerview.databinding.ItemPhotoSputnikBinding
import com.example.m17_recyclerview.domain.Photos

class Adapter(
    private var onClick: (Int) -> Unit
):
    PagingDataAdapter<Photos, PhotoSputnikViewHolder> (DiffUtilCallback())           // + 3 Paging
//    RecyclerView.Adapter<PhotoSputnikViewHolder>()                                // 1 и 2
{
//
   private var data: List<Photos> = emptyList()

    fun setData(data: List<Photos>){                              // 1 и 2
        this.data = data                                          // 1 и 2
        notifyDataSetChanged()                                    // 1 и 2
    }                                                             // 1 и 2

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoSputnikViewHolder {
        Log.e("","onCreateViewHolder START")
        context = parent.context
        return PhotoSputnikViewHolder(
            ItemPhotoSputnikBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClick = onClick
        )
    }

    override fun onBindViewHolder(holder: PhotoSputnikViewHolder, position: Int) {
        Log.e("","onBindViewHolder START")
//        val item = data[position]/*[0].getOrNull(position)*/
        val item = getItem(position)                                                // + 3 Paging
        with(holder.binding){
            rover.text ="Rover: ${item?.rover?.name2}"
            camera.text = "Camera: ${item?.camera?.name1}"
            sol.text = "Sol: ${item?.sol}"
            date.text = "Date: ${item?.earthDate}"
            item.let {
                Glide
                    .with(photoSputnik.context)
                    .load(it?.imgSrc)
                    .into(photoSputnik)
            }
        }

        holder.itemView.setOnClickListener {
            // передать значение по клику
            onClick.invoke(position)
        }
    }

//   override fun getItemCount(): Int = data.size
}

class PhotoSputnikViewHolder(
    val binding: ItemPhotoSputnikBinding,
    var onClick: (Int) -> Unit
    ): RecyclerView.ViewHolder(binding.root){
        init{
            binding.root.setOnClickListener{
                onClick.invoke(absoluteAdapterPosition)
            }
        }
    }

class DiffUtilCallback: DiffUtil.ItemCallback<Photos>() {                                           // + 3 Paging
    override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean =                       // + 3 Paging
        oldItem.id1 == newItem.id1                                                                  // + 3 Paging
                                                                                                    // + 3 Paging
    override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean = oldItem == newItem // + 3 Paging
}