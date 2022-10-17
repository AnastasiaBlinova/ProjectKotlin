package com.example.m3_components

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.Toast
import com.example.m3_components.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var finishPoint = 0
    var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.text = "Start"

        binding.start.setOnClickListener {
            if (finishPoint > 0){
                binding.seekBar.isEnabled
                timerCount(timeSecond = finishPoint.toLong())
            }
            if (binding.start.text == "Reset"){
                binding.start.text = "Start"
                finishPoint = 0
                timerCount(timeSecond = finishPoint.toLong())
            }
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //уведомляет об изменении положения ползунка;
                binding.textView.text = (progress * 10).toString()
                finishPoint = progress * 10
                binding.progressBar.max = 60
                binding.progressBar.progress = finishPoint
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //уведомляет о том, что пользователь начал перемещать ползунок;
            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                //уведомляет о том, что пользователь закончил перемещать ползунок
            }
        }
        )
    }

    private fun timerCount (timeSecond: Long){
        timer?.cancel()
        timer = object : CountDownTimer(timeSecond*1000, 1000){
            override fun onTick(timeM: Long){
                //начало работы таймера
                binding.start.text = "Reset"
                binding.textView.text = (timeM/1000).toString()
                binding.progressBar.progress = (timeM/1000).toInt()
            }
            override fun onFinish() {
                //конец работы таймера
                Toast.makeText(this@MainActivity, "The timer is over", Toast.LENGTH_SHORT).show()
                binding.start.text = "Start"
                binding.seekBar.progress = 0
                binding.progressBar.progress = 0
                binding.textView.text = "0"
            }
        }.start()
    }
}