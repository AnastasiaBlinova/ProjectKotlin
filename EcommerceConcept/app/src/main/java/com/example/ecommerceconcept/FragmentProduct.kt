package com.example.ecommerceconcept

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecommerceconcept.databinding.FragmentProductDetailsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentProduct.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentProduct : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentProductDetailsBinding? = null
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
        _binding = FragmentProductDetailsBinding.inflate(inflater)

        binding.buttonBack.setOnClickListener {
            val intent = Intent(requireContext(), ActivityHome::class.java)
            startActivity(intent)
        }
        binding.buttonBasket.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentProduct3_to_fragmentMyCart2, /*args = bundle*/)
        }

        binding.buttonLike.setOnClickListener{
            Toast.makeText(requireContext(),"Product like you", Toast.LENGTH_LONG).show()
        }
        binding.buttonAdd.setOnClickListener{
            Toast.makeText(requireContext(),"Product added", Toast.LENGTH_SHORT).show()
        }

        binding.buttonMemory1.setOnClickListener{
            binding.buttonMemory1.setBackgroundColor(Color.parseColor("#FFD4B5"))
            binding.buttonMemory2.setBackgroundColor(Color.WHITE)
        }

        binding.buttonMemory2.setOnClickListener{
            binding.buttonMemory2.setBackgroundColor(Color.parseColor("#FFD4B5"))
            binding.buttonMemory1.setBackgroundColor(Color.WHITE)
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        //очистим переменные бандинга в этом методе
        _binding = null
    }
}