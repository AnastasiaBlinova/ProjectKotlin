package com.example.ecommerceconcept

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecommerceconcept.databinding.Activity2HomeBinding

class ActivityHome : AppCompatActivity() {
    private lateinit var binding: Activity2HomeBinding
    private val adapterPhones = AdapterBestSeller()
    private val adapterHotSales = AdapterHotSales()

    private var indexForHotSales = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2HomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initHotWSales()
        initBestSeller()
        changeCategoryColor()

        binding.filter.setOnClickListener{
            Toast.makeText(this, "The filter is under development", Toast.LENGTH_LONG).show()
        }
    }


    private fun changeCategoryColor(){
        binding.phoneButtonOff.setOnClickListener{
            binding.phoneButtonOff.visibility = View.GONE
            binding.phoneButtonOn.visibility = View.VISIBLE
            binding.computerButtonOff.visibility = View.VISIBLE
            binding.computerButtonOn.visibility = View.GONE
            binding.healthButtonOff.visibility = View.VISIBLE
            binding.healthButtonOn.visibility = View.GONE
            binding.booksButtonOff.visibility = View.VISIBLE
            binding.booksButtonOn.visibility = View.GONE
            binding.tvButtonOff.visibility = View.VISIBLE
            binding.tvButtonOn.visibility = View.GONE

            binding.phoneTextOff.visibility = View.GONE
            binding.phoneTextOn.visibility = View.VISIBLE
            binding.computerTextOff.visibility = View.VISIBLE
            binding.computerTextOn.visibility = View.GONE
            binding.healthTextOff.visibility = View.VISIBLE
            binding.healthTextOn.visibility = View.GONE
            binding.booksTextOff.visibility = View.VISIBLE
            binding.booksTextOn.visibility = View.GONE
            binding.tvTextOff.visibility = View.VISIBLE
            binding.tvTextOn.visibility = View.GONE
        }
        binding.computerButtonOff.setOnClickListener{
            binding.phoneButtonOff.visibility = View.VISIBLE
            binding.phoneButtonOn.visibility = View.GONE
            binding.computerButtonOff.visibility = View.GONE
            binding.computerButtonOn.visibility = View.VISIBLE
            binding.healthButtonOff.visibility = View.VISIBLE
            binding.healthButtonOn.visibility = View.GONE
            binding.booksButtonOff.visibility = View.VISIBLE
            binding.booksButtonOn.visibility = View.GONE
            binding.tvButtonOff.visibility = View.VISIBLE
            binding.tvButtonOn.visibility = View.GONE

            binding.phoneTextOff.visibility = View.VISIBLE
            binding.phoneTextOn.visibility = View.GONE
            binding.computerTextOff.visibility = View.GONE
            binding.computerTextOn.visibility = View.VISIBLE
            binding.healthTextOff.visibility = View.VISIBLE
            binding.healthTextOn.visibility = View.GONE
            binding.booksTextOff.visibility = View.VISIBLE
            binding.booksTextOn.visibility = View.GONE
            binding.tvTextOff.visibility = View.VISIBLE
            binding.tvTextOn.visibility = View.GONE
        }
        binding.healthButtonOff.setOnClickListener{
            binding.phoneButtonOff.visibility = View.VISIBLE
            binding.phoneButtonOn.visibility = View.GONE
            binding.computerButtonOff.visibility = View.VISIBLE
            binding.computerButtonOn.visibility = View.GONE
            binding.healthButtonOff.visibility = View.GONE
            binding.healthButtonOn.visibility = View.VISIBLE
            binding.booksButtonOff.visibility = View.VISIBLE
            binding.booksButtonOn.visibility = View.GONE
            binding.tvButtonOff.visibility = View.VISIBLE
            binding.tvButtonOn.visibility = View.GONE

            binding.phoneTextOff.visibility = View.VISIBLE
            binding.phoneTextOn.visibility = View.GONE
            binding.computerTextOff.visibility = View.VISIBLE
            binding.computerTextOn.visibility = View.GONE
            binding.healthTextOff.visibility = View.GONE
            binding.healthTextOn.visibility = View.VISIBLE
            binding.booksTextOff.visibility = View.VISIBLE
            binding.booksTextOn.visibility = View.GONE
            binding.tvTextOff.visibility = View.VISIBLE
            binding.tvTextOn.visibility = View.GONE
        }
        binding.booksButtonOff.setOnClickListener{
            binding.phoneButtonOff.visibility = View.VISIBLE
            binding.phoneButtonOn.visibility = View.GONE
            binding.computerButtonOff.visibility = View.VISIBLE
            binding.computerButtonOn.visibility = View.GONE
            binding.healthButtonOff.visibility = View.VISIBLE
            binding.healthButtonOn.visibility = View.GONE
            binding.booksButtonOff.visibility = View.GONE
            binding.booksButtonOn.visibility = View.VISIBLE
            binding.tvButtonOff.visibility = View.VISIBLE
            binding.tvButtonOn.visibility = View.GONE

            binding.phoneTextOff.visibility = View.VISIBLE
            binding.phoneTextOn.visibility = View.GONE
            binding.computerTextOff.visibility = View.VISIBLE
            binding.computerTextOn.visibility = View.GONE
            binding.healthTextOff.visibility = View.VISIBLE
            binding.healthTextOn.visibility = View.GONE
            binding.booksTextOff.visibility = View.GONE
            binding.booksTextOn.visibility = View.VISIBLE
            binding.tvTextOff.visibility = View.VISIBLE
            binding.tvTextOn.visibility = View.GONE
        }
        binding.tvButtonOff.setOnClickListener{
            binding.phoneButtonOff.visibility = View.VISIBLE
            binding.phoneButtonOn.visibility = View.GONE
            binding.computerButtonOff.visibility = View.VISIBLE
            binding.computerButtonOn.visibility = View.GONE
            binding.healthButtonOff.visibility = View.VISIBLE
            binding.healthButtonOn.visibility = View.GONE
            binding.booksButtonOff.visibility = View.VISIBLE
            binding.booksButtonOn.visibility = View.GONE
            binding.tvButtonOff.visibility = View.GONE
            binding.tvButtonOn.visibility = View.VISIBLE

            binding.phoneTextOff.visibility = View.VISIBLE
            binding.phoneTextOn.visibility = View.GONE
            binding.computerTextOff.visibility = View.VISIBLE
            binding.computerTextOn.visibility = View.GONE
            binding.healthTextOff.visibility = View.VISIBLE
            binding.healthTextOn.visibility = View.GONE
            binding.booksTextOff.visibility = View.VISIBLE
            binding.booksTextOn.visibility = View.GONE
            binding.tvTextOff.visibility = View.GONE
            binding.tvTextOn.visibility = View.VISIBLE
        }

    }

    private fun initHotWSales(){
        binding.apply {
            hotSales.layoutManager = GridLayoutManager(this@ActivityHome,1,
                GridLayoutManager.HORIZONTAL, false)
            hotSales.adapter = adapterHotSales
            var hotSales = DataClassHotSales(
                "Iphone 12",
                "Súper. Mega. Rápido.",
                "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both"
            )
            adapterHotSales.addHotSales(hotSales)
            indexForHotSales++
            seeMoreHotSales.setOnClickListener {
                if (indexForHotSales > 2) indexForHotSales = 0
                if (indexForHotSales == 0 )
                    hotSales = DataClassHotSales("Iphone 12", "Súper. Mega. Rápido.", "https://img.ibxk.com.br/2020/09/23/23104013057475.jpg?w=1120&h=420&mode=crop&scale=both"
                    )
                if (indexForHotSales == 1 )
                    hotSales = DataClassHotSales(
                    "Samsung Galaxy A71",
                    "Súper. Mega. Rápido.",
                    "https://cdn-2.tstatic.net/kupang/foto/bank/images/pre-order-samsung-galaxy-a71-laris-manis-inilah-rekomendasi-ponsel-harga-rp-6-jutaan.jpg"
                )
                if (indexForHotSales == 2)
                    hotSales = DataClassHotSales(
                    "Xiaomi Mi 11 ultra",
                    "Súper. Mega. Rápido.",
                    "https://static.digit.in/default/942998b8b4d3554a6259aeb1a0124384dbe0d4d5.jpeg"
                )
                adapterHotSales.addHotSales(hotSales)
                indexForHotSales++
            }
        }
    }

   private fun initBestSeller(){
       binding.apply {
           bestSeller.layoutManager = GridLayoutManager(this@ActivityHome,2)
           bestSeller.adapter = adapterPhones
           var phone = DataClassBestSeller(
               "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg",
               1047.00,
               1500.00,
               "Samsung Galaxy s20 Ultra")
           adapterPhones.addPhone(phone)

           phone = DataClassBestSeller(
               "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg",
               400.00,
               300.00,
               "Xiaomi Mi 10 Pro")
           adapterPhones.addPhone(phone)

           seeMorePhone.setOnClickListener {
               phone = DataClassBestSeller(
                   "https://opt-1739925.ssl.1c-bitrix-cdn.ru/upload/iblock/c01/c014d088c28d45b606ed8c58e5817172.jpg?160405904823488",
                   1047.00,
                   1600.00,
                   "Samsung Note 20 Ultra")
               adapterPhones.addPhone(phone)
               phone = DataClassBestSeller(
                   "https://www.benchmark.rs/assets/img/news/edge1.jpg",
                   400.00,
                   300.00,
                   "Motorola One Edge")
               adapterPhones.addPhone(phone)
               phone = DataClassBestSeller(
                   "https://shop.gadgetufa.ru/images/upload/52534-smartfon-samsung-galaxy-s20-ultra-12-128-chernyj_1024.jpg",
                   1047.00,
                   1500.00,
                   "Samsung Galaxy s20 Ultra")
               adapterPhones.addPhone(phone)
               phone = DataClassBestSeller(
                   "https://mi92.ru/wp-content/uploads/2020/03/smartfon-xiaomi-mi-10-pro-12-256gb-global-version-starry-blue-sinij-1.jpg",
                   400.00,
                   300.00,
                   "Xiaomi Mi 10 Pro")
               adapterPhones.addPhone(phone)
           }
       }
    }
}

