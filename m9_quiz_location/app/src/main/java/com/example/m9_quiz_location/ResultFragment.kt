package com.example.m7_quiz_fragments

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.m9_quiz_location.R
import com.example.m9_quiz_location.databinding.FragmentResultBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: Int? = null

    private var picture: Int? = null

    //создаем null переменную для бандинга и геттер
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getInt(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//создем бандинг и возвращаем корневое вью
        _binding = FragmentResultBinding.inflate(inflater)

        binding.replyAgain.setOnClickListener{
            findNavController().navigate(R.id.action_resultFragment_to_SecondFragment)
        }
        binding.answer1.text
        return binding.root
    }

    // здесь будет код, который будет отображать значение переданного аргумента
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.answer1.text = param1
        binding.answer2.text = param2
        binding.answer3.text = param3
        picture = param4

        if (picture == 1) {
            binding.sadPicture.visibility = ImageView.VISIBLE
            binding.normalPicture.visibility = ImageView.GONE
            binding.goodPicture.visibility = ImageView.GONE
            binding.wonderfulPicture.visibility = ImageView.GONE
        }
        if (picture == 2) {
            binding.sadPicture.visibility = ImageView.GONE
            binding.normalPicture.visibility = ImageView.VISIBLE
            binding.goodPicture.visibility = ImageView.GONE
            binding.wonderfulPicture.visibility = ImageView.GONE
        }
        if (picture == 3) {
            binding.sadPicture.visibility = ImageView.GONE
            binding.normalPicture.visibility = ImageView.GONE
            binding.goodPicture.visibility = ImageView.VISIBLE
            binding.wonderfulPicture.visibility = ImageView.GONE
        }
        if (picture == 4) {
            binding.sadPicture.visibility = ImageView.GONE
            binding.normalPicture.visibility = ImageView.GONE
            binding.goodPicture.visibility = ImageView.GONE
            binding.wonderfulPicture.visibility = ImageView.VISIBLE
        }
        // кнопка "пройти тест снова" расплывается на 50% от своего размера
        binding.replyAgain.animate().apply {
            duration = 3000
            scaleX(1.5f)
            scaleY(1.5f)
        }

        // изменение цвета у первого ответа
        ObjectAnimator.ofArgb(binding.answer1,
            "textColor",
            Color.parseColor("#009933"),
            Color.parseColor("#FF0066"),
            Color.parseColor("#3399CC"),
            Color.parseColor("#FFFF00")
        ). apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            start()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        //очистим переменные бандинга в этом методе
        _binding = null
    }
}