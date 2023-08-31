package com.example.m7_quiz_fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.m9_quiz_location.R
import com.example.m9_quiz_location.databinding.FragmentHelloBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Calendar

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HelloFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    //создаем null переменную для бандинга и геттер
    private var _binding: FragmentHelloBinding? = null
    private val binding get() = _binding!!

    private var chooseDate: FragmentHelloBinding? = null
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("dd-MM-yyyy")

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
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        chooseDate = FragmentHelloBinding.inflate(layoutInflater)

       // chooseDate!!.yourDate.setOnClickListener{
            //binding.yourDate.setOnClickListener{
           /* val constraints = CalendarConstraints.Builder()
                .setOpenAt(calendar.timeInMillis)
                .build()*/
                //val dateDialog =
            //MaterialDatePicker.Builder.datePicker()
                    //.setTitleText(resources.getString(R.string.choose_the_date))
                    //.build()
                    //.show()
               // dateDialog.addOnPositiveButtonClickListener { timeInMillis ->
                //    calendar.timeInMillis = timeInMillis
                //    Snackbar.make(chooseDate!!.yourDate, dateFormat.format(calendar.time), Snackbar.LENGTH_SHORT).show()
       // }
       /* val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.yourDate.setOnClickListener{
            val dpd = DatePickerDialog(requireContext(), DatePickerDialog.OnDateSetListener{view,mYear,mMonth, mDay ->}, year,month,day )
            dpd.show()
            Snackbar.make(binding.yourDate, dateFormat.format(calendar.time),Snackbar.LENGTH_SHORT).show()
        }*/
        //val c = Calendar.getInstance()
        //val year = c.get(Calendar.YEAR)
        //val month = c.get(Calendar.MONTH)
        //val day = c.get(Calendar.DAY_OF_MONTH)

        binding.yourDate.setOnClickListener{
            val dateDialog = MaterialDatePicker.Builder.datePicker()
                .setTitleText(resources.getString(R.string.choose_the_date))
                .build()
            dateDialog.addOnPositiveButtonClickListener { timeInMillis ->
                calendar.timeInMillis = timeInMillis
                Snackbar.make(binding.yourDate, dateFormat.format(calendar.time),Snackbar.LENGTH_LONG).show()
            }
            dateDialog.show(requireFragmentManager(),"")

            //val dpd = DatePickerDialog(requireContext(),{view,mYear,mMonth, mDay ->}, year,month,day )
            //dpd.show()
            //Snackbar.make(binding.yourDate, dateFormat.format(calendar.time),Snackbar.LENGTH_SHORT).show()
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