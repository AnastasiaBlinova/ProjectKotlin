package com.example.labone

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.labone_.R
import com.google.android.material.switchmaterial.SwitchMaterial

class ActivityTwo : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val finish = findViewById<Button>(R.id.finish)

        findViewById<SwitchMaterial>(R.id.switch1).setOnCheckedChangeListener { _, isChecked->
            if (isChecked) {
                imageView.setColorFilter(getColor(R.color.purple_200))
            } else {
                imageView.setColorFilter(getColor(R.color.purple_900))
            }
        }

        finish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}