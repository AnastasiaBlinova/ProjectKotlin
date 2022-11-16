package com.example.ecommerceconcept

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.Activity3ProductDetailsBinding
import com.squareup.picasso.Picasso

class AdapterProductDetails : RecyclerView.Adapter<AdapterProductDetails.PhonesHolder>() {
    val phonesList = ArrayList<DataClassProductDetails>()

    class PhonesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = Activity3ProductDetailsBinding.bind(itemView)
        val picture: ImageView = itemView.findViewById(R.id.pictureDetails)
        fun getPhone(phone: DataClassProductDetails) = with(binding){
            picture
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity3_product_details, parent, false)
 /*       view.setOnClickListener{
            val intent = Intent(parent.context, ActivityPhoneDetails::class.java)
            parent.context.startActivity(intent)
        }*/
        return PhonesHolder(view)
    }

    override fun onBindViewHolder(holder: PhonesHolder, position: Int) {
        Picasso.get().load(phonesList[position].photo).into(holder.picture)
        holder.getPhone(phonesList[position])
    }

    override fun getItemCount() = phonesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addPhone(phone: DataClassProductDetails){
        phonesList.add(phone)
        notifyDataSetChanged()
    }


}