package com.example.m7_quiz_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.example.m5_quiz_resources.Question
import com.example.m5_quiz_resources.QuizStorage
import com.example.m7_quiz_fragments.databinding.FragmentResultBinding

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
        if (picture == 1) {
            binding.sadPicture.isVisible
            binding.normalPicture.isInvisible
            binding.goodPicture.isInvisible
            binding.wonderfulPicture.isInvisible
        }
        if (picture == 2) {
            binding.sadPicture.isInvisible
            binding.normalPicture.isVisible
            binding.goodPicture.isInvisible
            binding.wonderfulPicture.isInvisible
        }
        if (picture == 3) {
            binding.sadPicture.isInvisible
            binding.normalPicture.isInvisible
            binding.goodPicture.isVisible
            binding.wonderfulPicture.isInvisible
        }
        if (picture == 4) {
            binding.sadPicture.isInvisible
            binding.normalPicture.isInvisible
            binding.goodPicture.isInvisible
            binding.wonderfulPicture.isVisible
        }

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
        binding.replyAgain.setOnClickListener {
//            parentFragmentManager.commit {
//                replace<AskFragment>(R.id.fragment_hello)
//                //добавление перехода в стек чтобы не выбивало
//                addToBackStack(AskFragment::class.java.simpleName)
            //удалить два перехода
//                parentFragmentManager.popBackStack()
//                parentFragmentManager.popBackStack()
//            }
            findNavController().navigate(R.id.action_resultFragment_to_SecondFragment)
            //добавление перехода в стек чтобы не выбивало
//                addToBackStack(AskFragment::class.java.simpleName)
            //удалить два перехода
//                parentFragmentManager.popBackStack()
//                parentFragmentManager.popBackStack()
        }


        return binding.root

    }

    // здесь будет код, который будет отображать значение переданного аргумента
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.answer1.text = param1
        binding.answer2.text = param2
        binding.answer3.text = param3
        picture = param4

    }

    //уничтожаем созданное вью для фрагментов и освобождаем память
    override fun onDestroyView() {
        super.onDestroyView()
        //очистим переменные бандинга в этом методе
        _binding = null
    }
}