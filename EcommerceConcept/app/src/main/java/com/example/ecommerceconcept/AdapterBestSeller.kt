package com.example.ecommerceconcept

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.Activity2HomeBinding
import com.example.ecommerceconcept.databinding.WindowForBestSellerBinding
import com.squareup.picasso.Picasso

class AdapterBestSeller/*(private val products: ArrayList<Phones>)*/: RecyclerView.Adapter<AdapterBestSeller.PhonesHolder>() {
    val phonesList = ArrayList<DataClassBestSeller>()

    class PhonesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = WindowForBestSellerBinding.bind(itemView)
        val picture: ImageView = itemView.findViewById(R.id.picture)
        fun getPhone(phone: DataClassBestSeller) = with(binding){
//            val picture: ImageView = itemView.findViewById(R.id.picture)
 //           val price: TextView = itemView.findViewById(R.id.price)
 //           picture.te = phone.picture
//            picture.setImageResource(phone.picture)
            picture
            price.text = phone.price.toString()
            oldPrice.text = phone.oldPrice.toString()
            model.text = phone.model
        }
//        val title: TextView = itemView.findViewById(R.id.model)
//        val price: TextView = itemView.findViewById(R.id.price)
    }
//берем разметку и превращаем во вью
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.window_for_best_seller, parent, false)
        view.setOnClickListener{
            val intent = Intent(parent.context, ActivityPhoneDetails::class.java)
            parent.context.startActivity(intent)
        }
        return PhonesHolder(view)
    }

    override fun onBindViewHolder(holder: PhonesHolder, position: Int) {
       Picasso.get().load(phonesList[position].picture).into(holder.picture)
        holder.getPhone(phonesList[position])
//        val product = phonesList[position]
//        Picasso.get().load(product.picture).into(holder.image)
//        holder.title.text = product.model
//        holder.price.text = product.price.toString()
    }

    override fun getItemCount() = phonesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addPhone(phone: DataClassBestSeller){
        phonesList.add(phone)
        notifyDataSetChanged()
    }

    fun addPhoneAll(list: List<DataClassBestSeller>){
        phonesList.clear()
        phonesList.addAll(list)
        notifyDataSetChanged()
    }


}