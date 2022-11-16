package com.example.ecommerceconcept

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ecommerceconcept.databinding.FragmentMyCartBinding
import com.example.ecommerceconcept.databinding.FragmentProductDetailsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMyCart.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMyCart : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentMyCartBinding? = null
    private val binding get() = _binding!!
    var counter = 1
    private var price = 1500

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
        _binding = FragmentMyCartBinding.inflate(inflater)
        binding.textCounter.text = counter.toString()
        binding.priceTotal.text = price.toString()

        binding.buttonMinus.setOnClickListener{
            if (counter <= 0){
                binding.priceTotal.text = "0"
                binding.textCounter.text = "0"
            }
            price = 1500
            counter --
            price *=counter
            binding.textCounter.text = counter.toString()
            binding.priceTotal.text = price.toString()
        }
        binding.buttonPlus.setOnClickListener{
            price = 1500
            counter ++
            price *=counter
            binding.textCounter.text = counter.toString()
            binding.priceTotal.text = price.toString()
        }

        binding.garbage.setOnClickListener{
            price = 0
            counter = 0
            binding.priceTotal.text = "0"
            binding.textCounter.text = "0"
        }
        binding.buttonBack.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentMyCart2_to_fragmentProduct3)
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentMyCart.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMyCart().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}