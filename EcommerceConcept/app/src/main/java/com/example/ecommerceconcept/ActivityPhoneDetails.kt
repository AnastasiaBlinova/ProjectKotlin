package com.example.ecommerceconcept

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecommerceconcept.databinding.Activity3ProductDetailsBinding

class ActivityPhoneDetails: AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: Activity3ProductDetailsBinding
//    private val adapterPhones = AdapterProductDetails()
//    private var indexForPhone = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity3ProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        init()

    }
 /*   private fun init() {
        binding.apply {
            cardPhoneDetails.layoutManager = GridLayoutManager(this@ActivityPhoneDetails,1,GridLayoutManager.HORIZONTAL,false)
            cardPhoneDetails.adapter = adapterPhones
            var photo = DataClassProductDetails("https://avatars.mds.yandex.net/get-mpic/5235334/img_id5575010630545284324.png/orig")
            adapterPhones.addPhone(photo)
/*            indexForPhone++
            photo = DataClassProductDetails("https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg")
            adapterPhones.addPhone(photo)
            indexForPhone++*/
        }
    }*/
 override fun onSupportNavigateUp(): Boolean {
     val navController = findNavController(R.id.fragmentProduct)
     return navController.navigateUp(appBarConfiguration)
             || super.onSupportNavigateUp()
 }
}