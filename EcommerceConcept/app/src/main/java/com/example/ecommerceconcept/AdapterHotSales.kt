package com.example.ecommerceconcept

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconcept.databinding.WindowForHotSalesBinding
import com.squareup.picasso.Picasso

class AdapterHotSales : RecyclerView.Adapter<AdapterHotSales.HotSalesHolder>() {
    val hotSalesList = ArrayList<DataClassHotSales>()

    class HotSalesHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = WindowForHotSalesBinding.bind(itemView)
        val picture: ImageView = itemView.findViewById(R.id.hotSalesPhoto)

        fun getPhone(hotSales: DataClassHotSales) = with(binding){
            picture
            title.text = hotSales.title.toString()
            subTitle.text = hotSales.subtitle.toString()
        }
//
//        val title: TextView = itemView.findViewById(R.id.model)
//        val price: TextView = itemView.findViewById(R.id.price)
    }
    //берем разметку и превращаем во вью
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.window_for_hot_sales, parent, false)
 /*       view.setOnClickListener{
            val intent = Intent(parent.context, PhoneDetails::class.java)
            parent.context.startActivity(intent)
        }*/
        return HotSalesHolder(view)
    }

    override fun onBindViewHolder(holder: HotSalesHolder, position: Int) {
        Picasso.get().load(hotSalesList[position].photo).into(holder.picture)
        holder.getPhone(hotSalesList[position])
//        val product = phonesList[position]
//        Picasso.get().load(product.picture).into(holder.image)
//        holder.title.text = product.model
//        holder.price.text = product.price.toString()
    }

    override fun getItemCount() = hotSalesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun addHotSales(hotSales: DataClassHotSales){
        hotSalesList.add(hotSales)
        notifyDataSetChanged()
    }

/*    fun addPhoneAll(list: List<Phones>){
        hotSalesList.clear()
        hotSalesList.addAll(list)
        notifyDataSetChanged()
    }*/


}