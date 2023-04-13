package com.example.list

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.list.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.time.LocalTime

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NewTaskSheet (var taskItem: TaskItemBD?): DialogFragment() { //BottomSheetDialogFragment()
    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var taskViewModel: TaskViewModel
    private var dueTime: LocalTime? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (taskItem != null){
            binding.taskTitle.text = "Edit Task"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(taskItem!!.name)
            binding.desc.text = editable.newEditable(taskItem!!.desc)
            if(taskItem!!.dueTime != null){
                dueTime = taskItem!!.dueTime!!
                updateTimeButtonText()
            }
        }else{
            binding.taskTitle.text = "New Task"
        }
        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.saveButton.setOnClickListener{

            saveAction()
                //val intent = Intent(requireContext(), MainActivity::class.java)
                //startActivity(intent)
        }
        binding.timePickerButton.setOnClickListener {
            openTimePicker()
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun openTimePicker(){
        if(dueTime == null)
            dueTime = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
            dueTime = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonText()
        }
        val dialog = TimePickerDialog(activity, listener, dueTime!!.hour, dueTime!!.minute, true)
        dialog.setTitle("Task Due")
        dialog.show()
    }
    
    @RequiresApi(Build.VERSION_CODES.O)
    private fun updateTimeButtonText(){
        binding.timePickerButton.text = String.format("%02d:%02d", dueTime!!.hour, dueTime!!.minute)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTaskSheetBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun saveAction(){
        val name= binding.name.text.toString()
        val desc = binding.desc.text.toString()
        if (taskItem == null){
            val newTask = TaskItemBD(name, desc, dueTime,null)
            taskViewModel.addTaskItem(newTask)
        }else{
            taskViewModel.updateTaskItem(taskItem!!.id, name, desc, dueTime)
        }
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }

}