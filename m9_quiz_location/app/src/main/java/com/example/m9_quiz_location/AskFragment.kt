package com.example.m7_quiz_fragments

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.m5_quiz_resources.QuizStorage
import com.example.m9_quiz_location.R
import com.example.m9_quiz_location.databinding.FragmentAskBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"
/**
 * A simple [Fragment] subclass.
 * Use the [AskFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AskFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: Int? = null

    private var answer1: String? = null
    private var answer2: String? = null
    private var answer3: String? = null
    private var picture: Int? = null

    //для анимации
    private lateinit var animation: Animation


    //создаем null переменную для бандинга и геттер
    private var _binding: FragmentAskBinding? = null
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
    // (binding.radioButton1.isChecked.toString()) -> QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].feedback[0]
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//создем бандинг и возвращаем корневое вью
        _binding = FragmentAskBinding.inflate(inflater)
//Передаю данные вопросов
        binding.question1.text = resources.getString(R.string.question_1)
        binding.question2.text = resources.getString(R.string.question_2)
        binding.question3.text = resources.getString(R.string.question_3)
//Передаю данные вариантов ответов на все вопросы
        binding.radioButton1.text = resources.getString(R.string.answers_1_1)
        binding.radioButton2.text = resources.getString(R.string.answers_1_2)
        binding.radioButton3.text = resources.getString(R.string.answers_1_3)
        binding.radioButton4.text = resources.getString(R.string.answers_1_4)

        binding.radioButton5.text = resources.getString(R.string.answers_2_1)
        binding.radioButton6.text = resources.getString(R.string.answers_2_2)
        binding.radioButton7.text = resources.getString(R.string.answers_2_3)
        binding.radioButton8.text = resources.getString(R.string.answers_2_4)

        binding.radioButton9.text = resources.getString(R.string.answers_3_1)
        binding.radioButton10.text = resources.getString(R.string.answers_3_2)
        binding.radioButton11.text = resources.getString(R.string.answers_3_3)
        binding.radioButton12.text = resources.getString(R.string.answers_3_4)

        binding.back.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.share.setOnClickListener {
// проверяю каждый ответ на "выбранность" и присваиваю соответствующий результат
            if (binding.radioButton1.isChecked){
                answer1 = resources.getString(R.string.feedback_1_1)
                picture = 1}
            if (binding.radioButton2.isChecked){
                answer1 = resources.getString(R.string.feedback_1_2)
                picture = 2}
            if (binding.radioButton3.isChecked){
                answer1 =resources.getString(R.string.feedback_1_3)
                picture = 3}
            if (binding.radioButton4.isChecked){
                answer1= resources.getString(R.string.feedback_1_4)
                picture = 4}

            if (binding.radioButton5.isChecked)
                answer2 = resources.getString(R.string.feedback_2_1)
            if (binding.radioButton6.isChecked)
                answer2 = resources.getString(R.string.feedback_2_2)
            if (binding.radioButton7.isChecked)
                answer2 = resources.getString(R.string.feedback_2_3)
            if (binding.radioButton8.isChecked)
                answer2= resources.getString(R.string.feedback_2_4)

            if (binding.radioButton9.isChecked)
                answer3 = resources.getString(R.string.feedback_3_1)
            if (binding.radioButton10.isChecked)
                answer3 = resources.getString(R.string.feedback_3_2)
            if (binding.radioButton11.isChecked)
                answer3 = resources.getString(R.string.feedback_3_3)
            if (binding.radioButton12.isChecked)
                answer3= resources.getString(R.string.feedback_3_4)

            if (answer1 == null || answer2 == null || answer3 == null) {
                Toast.makeText(requireContext(), "Ответьте на все вопросы", Toast.LENGTH_SHORT)
                    .show()
            }
            val bundle = Bundle().apply {
                putString("param1", answer1)
                putString("param2", answer2)
                putString("param3", answer3)
               putInt("param4", picture!!)
            }
            if((binding.radioButton1.isChecked || binding.radioButton2.isChecked ||
                        binding.radioButton3.isChecked || binding.radioButton4.isChecked) && (
                        binding.radioButton5.isChecked || binding.radioButton6.isChecked ||
                                binding.radioButton7.isChecked || binding.radioButton8.isChecked) && (
                        binding.radioButton9.isChecked || binding.radioButton10.isChecked ||
                                binding.radioButton11.isChecked || binding.radioButton12.isChecked)){

                findNavController().navigate(R.id.action_SecondFragment_to_resultFragment, args = bundle)

            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.question1.animate().apply {
            duration = 1000
            alpha(1f)
        }
        binding.radioButton1.animate().apply {
            duration = 2000
            alpha(1f)
        }
        binding.radioButton2.animate().apply {
            duration = 3000
            alpha(1f)
        }
        binding.radioButton3.animate().apply {
            duration = 4000
            alpha(1f)
        }
        binding.radioButton4.animate().apply {
            duration = 5000
            alpha(1f)
        }

    }

    //уничтожаем созданное вью для фрагментов и освобождаем память
    override fun onDestroyView() {
        super.onDestroyView()
        //очистим переменные бандинга в этом методе
        _binding = null
    }
}