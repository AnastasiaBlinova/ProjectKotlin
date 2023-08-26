package com.example.readcontacts

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.readcontacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val  launcher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if (isGranted){
            getContacts()
        } else {
            Toast.makeText(this,"Permission is not Granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        checkPermissions()
    }

    private fun checkPermissions() {
        return if (
            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ){
            getContacts()
        } else {
            launcher.launch(android.Manifest.permission.READ_CONTACTS)
        }
    }

    private fun getContacts() {
        TODO("Not yet implemented")
    }
}