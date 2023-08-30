package com.example.m10_timer_life_cycle

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.SeekBar
import android.widget.Toast
import com.example.m10_timer_life_cycle.databinding.ActivityMainBinding

private const val KEY_PROGRESS_BAR = "progressBar"
private const val KEY_SEEK_BAR = "seekBar"
private const val KEY_BUTTON = "textButton"
private const val KEY_TEXT = "count"


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var finishPoint = 0
    var timer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*savedInstanceState?.let { bundle ->
            bundle.getInt(KEY_PROGRESS_BAR, binding.progressBar.progress)
            bundle.getInt(KEY_SEEK_BAR, binding.seekBar.progress )
            bundle.getString(KEY_BUTTON, binding.textView.text.toString())
            bundle.getString(KEY_TEXT, binding.start.text.toString())

        }*/

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

        })

    }

    private fun timerCount (timeSecond: Long){
        timer?.cancel()
        Log.d(TAG, "timerCount" )
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)     // значения, которые сохраняем
        Log.d(TAG, "onSaveInstanceState" )
        outState.putInt(KEY_PROGRESS_BAR, binding.progressBar.progress)
        outState.putInt(KEY_SEEK_BAR, finishPoint)
        //outState.putLong("RRRRR", timer )
        //  outState.putLong("MILLIS", timer)
        outState.putString(KEY_TEXT, binding.textView.text.toString())
        outState.putString(KEY_BUTTON, binding.start.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) { // значения, которые получаем после сохранения
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState" )
        //binding.progressBar.progress = savedInstanceState.getInt(KEY_PROGRESS_BAR,binding.progressBar.progress)
        binding.start.text = savedInstanceState.getString(KEY_BUTTON, binding.start.text.toString())
        finishPoint = savedInstanceState.getInt(KEY_SEEK_BAR,finishPoint)
        binding.textView.text  =
            savedInstanceState.getString(KEY_TEXT, binding.textView.text.toString())
        binding.progressBar.progress =
            savedInstanceState.getLong(KEY_PROGRESS_BAR, binding.progressBar.progress.toLong()).toInt()
        timerCount(savedInstanceState.getInt(KEY_PROGRESS_BAR, binding.progressBar.progress).toLong())

    }
}