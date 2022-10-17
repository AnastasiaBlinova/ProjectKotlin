package com.example.m7_quiz_fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.findNavController
import com.example.m7_quiz_fragments.databinding.FragmentHelloBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HelloFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HelloFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//создаем null переменную для бандинга и геттер
    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//создем бандинг и возвращаем корневое вью
        _binding = FragmentHelloBinding.inflate(inflater)
//прописываем переход в другой фрагмент по нажатию на кнопку buttonShareThoughts
        binding.buttonShareThoughts.setOnClickListener {
            parentFragmentManager.commit {
                replace<AskFragment>(R.id.fragment_hello)
                //добавление перехода в стек чтобы не выбивало
                addToBackStack(AskFragment::class.java.simpleName)
            }
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        return binding.root
    }

//уничтожаем созданное вью для фрагментов и освобождаем память
    override fun onDestroyView() {
        super.onDestroyView()
    //очистим переменные бандинга в этом методе
        _binding = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HelloFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HelloFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}