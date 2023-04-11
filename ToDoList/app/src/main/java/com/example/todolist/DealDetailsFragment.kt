package com.example.todolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.Fragment2DealDetailsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DealDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DealDetailsFragment : Fragment() {

    private var _binding: Fragment2DealDetailsBinding? = null
    private val binding get() = _binding!!

    // TODO: Rename and change types of parameters
    private var param1: String? = null // change time
   // private var time: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("param1") { param1, bundle ->
            Log.e("!!!", "$param1, $bundle")
            val result = bundle.getString("param1")
            binding.choosedTime.text = result
        }
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment2DealDetailsBinding.inflate(inflater)
       // LocalDate.parse(param1, "mm.dd.")
        //LocalDateTime.now(ZoneId.systemDefault()).
        binding.chooseTime.setOnClickListener {
            var dialog = CustomDialogFragment()
            dialog.show(requireFragmentManager(),"")
            binding.choosedTime.text = param1
        }
        
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_dealDetailsFragment_to_mainFragment)
        }

        binding.saveButton.setOnClickListener {
            findNavController().navigate(R.id.action_dealDetailsFragment_to_mainFragment)
        }

        binding.garbageButton.setOnClickListener {
            findNavController().navigate(R.id.action_dealDetailsFragment_to_mainFragment)
        }
        return binding.root
    }

    // здесь будет код, который будет отображать значение переданного аргумента
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.choosedTime.text = param1
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DealDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
       /* @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DealDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    //putString(ARG_PARAM2, param2)
                }
            }*/
    }
}