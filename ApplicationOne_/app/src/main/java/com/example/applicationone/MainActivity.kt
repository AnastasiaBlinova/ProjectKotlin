package com.example.applicationone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.applicationone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var counter = 0
    var place = "All seats are free"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.people.text = counter.toString()
        binding.placeGreen.text = place

        binding.plusOneButton.setOnClickListener {
            if (counter < 29)
            {counter++
                place = "Seats left: ${30-counter}"
                binding.placeGreen.text = place
            }
            else {
                binding.placeGreen.text = null
                place = "No seats available"
                binding.placeRed.text = place
                counter = 30
                binding.people.text = counter.toString()
            }
            binding.people.text = counter.toString()
        }

        binding.minusTwoButton.setOnClickListener {
            if (counter ==0)
                place = "Seats left: ${30-counter}"
            else
            {counter--
                binding.placeRed.text = null
                place = "Seats left: ${30-counter}"

            }
            binding.placeGreen.text = place
            binding.people.text = counter.toString()
        }

        binding.reset.setOnClickListener {
            counter = 0
            place = "All seats are free"
            binding.people.text = counter.toString()
            binding.placeGreen.text = place
            binding.placeRed.text = null
            binding.people.text = counter.toString()
        }
    }
}