package com.example.breathretention.presentation

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.breathretention.R
import com.example.breathretention.databinding.FragmentThirdBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    var finishPoint = 60
    var timer: CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdBinding.inflate(inflater)
        binding.lottieView.visibility = ImageView.INVISIBLE
        binding.button.setOnClickListener {
            binding.lottieView.visibility = ImageView.INVISIBLE
            binding.progressBar.max = 60
            binding.progressBar.progress = finishPoint
            if (finishPoint > 0){
                timerCount(timeSecond = finishPoint.toLong())
            }
            if (binding.button.text == "Stop"){
                binding.button.text = "Let's start"
                finishPoint = 0
                timerCount(timeSecond = finishPoint.toLong())
               // binding.progressBar.progress = 60
                binding.lottieView.visibility = ImageView.VISIBLE
                return@setOnClickListener
            }
            if (binding.button.text == "Let's start"){
                finishPoint = 60
                binding.progressBar.progress = finishPoint
                timerCount(timeSecond = finishPoint.toLong())
            }
        }
        return binding.root
    }

    private fun timerCount (timeSecond: Long){
        timer?.cancel()
        timer = object : CountDownTimer(timeSecond*1000, 1000){
            override fun onTick(timeM: Long){
                //начало работы таймера
                binding.button.text = "Stop"
                binding.time.text = (60 - (timeM/1000)).toString()
                binding.progressBar.progress = (timeM/1000).toInt()
            }
            override fun onFinish() {
                //конец работы таймера
                //Toast.makeText(context, "The timer is over", Toast.LENGTH_SHORT).show()
                binding.button.text = "Let's start"
                binding.progressBar.progress = 0
            }
        }.start()
    }
    //уничтожаем созданное вью для фрагментов и освобождаем память
    override fun onDestroyView() {
        super.onDestroyView()
        //очистим переменные бандинга в этом методе
        _binding = null
    }


}