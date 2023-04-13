package com.example.todolist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.Fragment2DealDetailsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "date"

/**
 * A simple [Fragment] subclass.
 * Use the [DealDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DealDetailsFragment(var deeds: Deeds) : Fragment() {

    private var _binding: Fragment2DealDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    // TODO: Rename and change types of parameters
    private var param1: String? = null // change time
    private var date: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("param1") { param1, bundle ->
            Log.e("!!!", "$param1, $bundle")
            val result = bundle.getString("param1")
            binding.choosedTime.text = result
        }

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            date = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment2DealDetailsBinding.inflate(inflater)
       // LocalDate.parse(param1, "mm.dd.")
        //LocalDateTime.now(ZoneId.systemDefault()).
        binding.dateString.text = date
        binding.chooseTime.setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(requireFragmentManager(),"")
            binding.choosedTime.text = param1
        }
        
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_dealDetailsFragment_to_mainFragment)
        }

        binding.saveButton.setOnClickListener {
            saveAction()
            findNavController().navigate(R.id.action_dealDetailsFragment_to_mainFragment)
        }

        binding.garbageButton.setOnClickListener {
            findNavController().navigate(R.id.action_dealDetailsFragment_to_mainFragment)
        }
        return binding.root


    }
    fun saveAction(){
        val name= binding.name.text.toString()
        val desc = binding.description.text.toString()
        binding.name.setText("")
        binding.description.setText("")
    }

    // здесь будет код, который будет отображать значение переданного аргумента
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragment = requireActivity()
        if (deeds != null)
        viewModel = ViewModelProvider(fragment).get(MainViewModel::class.java)
        binding.choosedTime.text = param1
        binding.dateString.text = date
    }


}