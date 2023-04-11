package com.example.todolist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.Fragment1MainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: Fragment1MainBinding? = null
    private val binding get() = _binding!!
    val calendar = Calendar.getInstance()
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
       /* val dateDialog = MaterialDatePicker.Builder.datePicker()
            .setTitleText("aaaaa")
            //.setTitleText(resources.getString(R.string.choose_the_date))
            .build()
        dateDialog.addOnPositiveButtonClickListener { timeInMillis ->
            calendar.timeInMillis = timeInMillis
            //Snackbar.make(binding.yourDate, dateFormat.format(calendar.time), Snackbar.LENGTH_LONG).show()
        }
        dateDialog.show(requireFragmentManager(),"")*/

        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_dealDetailsFragment)
        }


        return binding.root

        //return inflater.inflate(R.layout.fragment_main, container, false)
    }

}