package com.example.list

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.list.databinding.FragmentDealDetailsBinding
import java.time.LocalTime

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DealDetailsFragment (var taskItem: TaskItemBD?): DialogFragment() { //BottomSheetDialogFragment()

    private lateinit var binding: FragmentDealDetailsBinding
    private lateinit var taskViewModel: TaskViewModel
    private var dueTime: LocalTime? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (taskItem != null){
            binding.taskTitle.text = "Edit Task"
            val editable = Editable.Factory.getInstance()
           // binding.dateString.text = ""
            binding.name.text = editable.newEditable(taskItem!!.name)
            binding.desc.text = editable.newEditable(taskItem!!.desc)
            if(taskItem!!.dueTime() != null){
                dueTime = taskItem!!.dueTime()!!
                updateTimeButtonTextStart()
                updateTimeButtonTextFinish()
            }
        }else{
            binding.taskTitle.text = "New Task"
        }

        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)

        binding.saveButton.setOnClickListener{
            saveAction()
        }

        binding.timePickerButton.setOnClickListener {
            openTimePickerFinish()
        }
        binding.timePicker.setOnClickListener {
            openTimePickerStart()
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }
    private fun openTimePickerFinish(){
        if(dueTime == null)
            dueTime = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
            dueTime = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonTextFinish()
        }
        val dialog = TimePickerDialog(activity, listener, dueTime!!.hour, dueTime!!.minute, true)
        dialog.setTitle("Choose time")
        dialog.show()
    }

    private fun openTimePickerStart(){
        if(dueTime == null)
            dueTime = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
            dueTime = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonTextStart()
        }
        val dialog = TimePickerDialog(activity, listener, dueTime!!.hour, dueTime!!.minute, true)
        dialog.setTitle("Choose time")
        dialog.show()
    }
    private fun updateTimeButtonTextFinish(){
        binding.timePickerButton.text = String.format("%02d:%02d", dueTime!!.hour, dueTime!!.minute)
    }

    private fun updateTimeButtonTextStart(){
        binding.timePicker.text = String.format("%02d:%02d", dueTime!!.hour, dueTime!!.minute)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDealDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun saveAction(){
        val name= binding.name.text.toString()
        val desc = binding.desc.text.toString()
        //val date = binding.dateString.text.toString()
        val dueTimeString = if(dueTime == null) null else TaskItemBD.timeFormatter.format(dueTime)
        if (taskItem == null){
            val newTask = TaskItemBD(name, desc, /*date,*/ dueTimeString,null)
            taskViewModel.addTaskItem(newTask)
        }else{
            taskItem!!.name = name
            taskItem!!.desc = desc
           // taskItem!!.date = date
            taskItem!!.dueTimeString = dueTimeString
            taskViewModel.updateTaskItem(taskItem!!)
        }
        binding.dateString.text = ""
        binding.name.setText("")
        binding.desc.setText("")
        dismiss()
    }
}