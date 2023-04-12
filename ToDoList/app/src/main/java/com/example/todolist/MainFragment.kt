package com.example.todolist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.Fragment1MainBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainFragment : Fragment() {

    private var date: String? = null
    private var param2: String? = null

    private var dateString: String? = null
    private var answer2: String? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: Fragment1MainBinding? = null
    private val binding get() = _binding!!
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd.MM.yyyy")
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            date = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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

        val currentDate = dateFormat.format(Date())
        //System.out.println(" C DATE is  "+currentDate)
        binding.message.text = currentDate
        dateString = currentDate

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
            dateString = date
        }



            //dateDialog.show(requireFragmentManager(),"")


        binding.floatingActionButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("date", dateString)
                //putString("param3", answer2)
            }
            Log.e("!!!", "$dateString, $bundle")
            findNavController().navigate(R.id.action_mainFragment_to_dealDetailsFragment, args = bundle)

        }

        return binding.root
    }

}