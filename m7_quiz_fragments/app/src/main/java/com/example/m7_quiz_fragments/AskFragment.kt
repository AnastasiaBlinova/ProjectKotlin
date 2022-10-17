package com.example.m7_quiz_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.example.m5_quiz_resources.Question
import com.example.m5_quiz_resources.QuizStorage
import com.example.m7_quiz_fragments.databinding.FragmentAskBinding

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
        binding.question1.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].question
        binding.question2.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].question
        binding.question3.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].question
//Передаю данные вариантов ответов на все вопросы
        binding.radioButton1.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].answers[0]
        binding.radioButton2.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].answers[1]
        binding.radioButton3.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].answers[2]
        binding.radioButton4.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].answers[3]

        binding.radioButton5.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].answers[0]
        binding.radioButton6.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].answers[1]
        binding.radioButton7.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].answers[2]
        binding.radioButton8.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].answers[3]

        binding.radioButton9.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].answers[0]
        binding.radioButton10.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].answers[1]
        binding.radioButton11.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].answers[2]
        binding.radioButton12.text = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].answers[3]

       binding.back.setOnClickListener {
           // parentFragmentManager.commit {
                //replace<HelloFragment>(R.id.fragment_hello)
                //добавление перехода в стек чтобы не выбивало
                //addToBackStack(HelloFragment::class.java.simpleName)
            //}
           findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
       binding.share.setOnClickListener {
// проверяю каждый ответ на "выбранность" и присваиваю соответствующий результат
           if (binding.radioButton1.isChecked){
               answer1 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].feedback[0]
                picture = 1}
           if (binding.radioButton2.isChecked){
               answer1 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].feedback[1]
                picture = 2}
           if (binding.radioButton3.isChecked){
               answer1 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].feedback[2]
                picture = 3}
           if (binding.radioButton4.isChecked){
               answer1= QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[0].feedback[3]
                picture = 4}

           if (binding.radioButton5.isChecked)
               answer2 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].feedback[0]
           if (binding.radioButton6.isChecked)
               answer2 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].feedback[1]
           if (binding.radioButton7.isChecked)
               answer2 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].feedback[2]
           if (binding.radioButton8.isChecked)
               answer2= QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[1].feedback[3]

           if (binding.radioButton9.isChecked)
               answer3 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].feedback[0]
           if (binding.radioButton10.isChecked)
               answer3 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].feedback[1]
           if (binding.radioButton11.isChecked)
               answer3 = QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].feedback[2]
           if (binding.radioButton12.isChecked)
               answer3= QuizStorage.getQuiz(QuizStorage.Locale.Ru).questions[2].feedback[3]

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
                    //parentFragmentManager.commit {
                        //replace<ResultFragment>(containerViewId = R.id.fragment_hello, args = bundle)
                        //добавление перехода в стек чтобы не выбивало
                        //addToBackStack(ResultFragment::class.java.simpleName)
                        //удаление одного перехода из стека
                    //}
                    findNavController().navigate(R.id.action_SecondFragment_to_resultFragment)
               }
            else{
//уведомление пользователя о необходимости ответить на все вопросы
                Toast.makeText(requireContext(),"Ответьте на все вопросы", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

//уничтожаем созданное вью для фрагментов и освобождаем память
    override fun onDestroyView() {
        super.onDestroyView()
        //очистим переменные бандинга в этом методе
        _binding = null
    }
}