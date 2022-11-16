package com.example.ecommerceconcept

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerceconcept.databinding.Activity1SplashBinding

@Suppress("DEPRECATION")
class ActivitySplash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = Activity1SplashBinding.inflate(layoutInflater)
        makeSplash()

        Handler().postDelayed({
            startActivity(Intent(this,ActivityHome::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 4000)
        setContentView(binding.root)
    }

    private fun makeSplash(){
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        //supportActionBar?.hide()
    }

}