package com.example.todolist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.Fragment1MainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: Fragment1MainBinding? = null
    private val binding get() = _binding!!
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1MainBinding.inflate(inflater)
       /* binding.calendar.setOnDateChangeListener {view, year, month, dayOfMonth ->
            var date = binding.calendar.date

            binding.message.text = dateFormat.format(date)//"$dayOfMonth.${month + 1}.$year"

        }*/

        binding.calendar.setOnDateChangeListener {view, year, month, dayOfMonth ->
          //val date = dateFormat.parse("$dayOfMonth-${month + 1}-$year","dd-MM-yyyy")
            val changeD: String
            val changeM: String
            if ((month+1).toString().length < 2 )
                changeM = "0${month+1}"
            else changeM = "${month+1}"
            if (dayOfMonth.toString().length < 2 )
                changeD = "0$dayOfMonth"
            else changeD = "$dayOfMonth"
            //val date = "$dayOfMonth-${month + 1}-$year"
            val date = "$changeD.$changeM.$year"
            binding.message.text = date //"$dayOfMonth.${month + 1}.$year"

        }


            //dateDialog.show(requireFragmentManager(),"")

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_dealDetailsFragment)
        }


        return binding.root

        //return inflater.inflate(R.layout.fragment_main, container, false)
    }

}