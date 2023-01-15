package com.example.testcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.testcard.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var param1: Int? = null
    private var param2: Int? = null
    private var param3: Int? = null
    private var param4: Int? = null

    private var number1: Int? = null
    private var number2: Int? = null
    private var number3: Int? = null
    private var number4: Int? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getInt(ARG_PARAM2)
            param3 = it.getInt(ARG_PARAM3)
            param4 = it.getInt(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)



        binding.buttonSave.setOnClickListener{
            Toast.makeText(requireContext(), "Number save", Toast.LENGTH_LONG)
                .show()
            if (number1 == null) number1 = binding.editNumberCard.text.toString().toInt()
            if (number1.toString().isNotEmpty() && number2 == null) number2 = binding.editNumberCard.text.toString().toInt()
            if (number3 == null) number3 = binding.editNumberCard.text.toString().toInt()
            if (number4 == null) number4 = binding.editNumberCard.text.toString().toInt()

        }
        binding.buttonSeeHistory.setOnClickListener {

            val bundle = Bundle().apply {
                putInt("param1", number1!!)
                putInt("param2", number2!!)
                putInt("param3", number3!!)
                putInt("param4", number4!!)
            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, args = bundle)
        }

        binding.editNumberCard.setOnClickListener{
            binding.lengthCardBank.text = binding.editNumberCard.text.length.toString()
            val startNumber = binding.editNumberCard.text.substring(0,binding.editNumberCard.text.length / 4)
            if (startNumber == "4571" ){
                binding.schemeNetworkBank.text = "Visa"
                binding.brandBank.text = "Visa/Dankort"
                binding.luhnCardBank.text = "Yes"
                binding.typeBank.text = "Debit"
                binding.prepaidBank.text = "No"
                binding.countryBank.text = "dk Denmark"
                binding.numberPhoneBank.text = "+4589893300"
                binding.siteBank.text = "www.jyskebank.dk"
                binding.nameBank.text = "Jyske Bank, Hjørring"

            }
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
