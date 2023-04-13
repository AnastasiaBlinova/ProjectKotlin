package com.example.todolist

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.todolist.databinding.FragmentCustomDialogBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1" // change time
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null // change time
    private var time: String? = null
   //private var param2: String? = null

    private var _binding: FragmentCustomDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            //param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustomDialogBinding.inflate(inflater)
        val rootView: View = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        binding.saveButton.setOnClickListener {
            try{
                Log.d(ContentValues.TAG, "начало клик")
                val selectedID = binding.radioGroup.checkedRadioButtonId
                val radio = rootView.findViewById<RadioButton>(selectedID).text.toString()
                time = radio
                val bundle = Bundle().apply {
                    putString("param1",time)
                }
                Toast.makeText(requireContext(), " selected $radio",Toast.LENGTH_LONG).show()
                setFragmentResult("param1", bundle)
                dismiss()
                Log.d(ContentValues.TAG, "конец клик param1 = $param1 , time = $time, bundle = $bundle")
            }catch(e:Exception){
                Toast.makeText(requireContext(), "Select time",Toast.LENGTH_LONG).show()
            }
            //findNavController().navigate(R.id.action_customDialogFragment_to_dealDetailsFragment, args = bundle)
        }
        return  binding.root
    }
}