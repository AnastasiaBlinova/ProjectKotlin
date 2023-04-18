package com.example.list

import android.app.TimePickerDialog
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.list.databinding.FragmentDealDetailsBinding
import java.time.LocalTime

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DealDetailsFragment (var taskItem: TaskItemBD?): DialogFragment() { //BottomSheetDialogFragment()

    private lateinit var binding: FragmentDealDetailsBinding
    private lateinit var taskViewModel: TaskViewModel
    private val dateViewModel: DateViewModel by activityViewModels()

    private var dueTimeStart: LocalTime? = null
    private var dueTimeFinish: LocalTime? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if (taskItem != null){
            binding.taskTitle.text = "Edit Task"
            val editable = Editable.Factory.getInstance()
           // binding.dateString.text = ""
            binding.name.text = editable.newEditable(taskItem!!.name)
            binding.desc.text = editable.newEditable(taskItem!!.desc)
            if(taskItem!!.dueTimeStart() != null && taskItem!!.dueTimeFinish() != null){
                dueTimeStart = taskItem!!.dueTimeStart()!!
                dueTimeFinish = taskItem!!.dueTimeFinish()!!
                updateTimeButtonTextStart()
                updateTimeButtonTextFinish()
            }
        }else{
            binding.taskTitle.text = "New Task"
        }

        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)

        dateViewModel.date.observe(viewLifecycleOwner) {
            binding.dateString.text = it
        }
        binding.saveButton.setOnClickListener{
            saveAction()
        }

        binding.timePicker.setOnClickListener {
            openTimePickerStart()
        }
        binding.timePickerButton.setOnClickListener {
            openTimePickerFinish()
        }

        binding.cancelButton.setOnClickListener {
            dismiss()
        }
    }
    private fun openTimePickerFinish(){
        if(dueTimeFinish == null)
            dueTimeFinish = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
            dueTimeFinish = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonTextFinish()
        }
        val dialog = TimePickerDialog(activity, listener, dueTimeFinish!!.hour, dueTimeFinish!!.minute, true)
        dialog.setTitle("Choose time")
        dialog.show()
    }

    private fun openTimePickerStart(){
        if(dueTimeStart == null)
            dueTimeStart = LocalTime.now()
        val listener = TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
            dueTimeStart = LocalTime.of(selectedHour, selectedMinute)
            updateTimeButtonTextStart()
        }
        val dialog = TimePickerDialog(activity, listener, dueTimeStart!!.hour, dueTimeStart!!.minute, true)
        dialog.setTitle("Choose time")
        dialog.show()
    }

    private fun updateTimeButtonTextStart(){
        binding.timePicker.text = " Start: ${String.format("%02d:%02d", dueTimeStart!!.hour, dueTimeStart!!.minute)}"
    }
    private fun updateTimeButtonTextFinish(){
        binding.timePickerButton.text = " Finish: ${String.format("%02d:%02d", dueTimeFinish!!.hour, dueTimeFinish!!.minute)}"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDealDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    private fun saveAction(){
        try {
            val name= binding.name.text.toString()
            val desc = binding.desc.text.toString()
            val date = binding.dateString.text.toString()
            val dueTimeStart = if(dueTimeStart == null) null else TaskItemBD.timeFormatter.format(dueTimeStart)
            val dueTimeFinish = if(dueTimeFinish == null) null else TaskItemBD.timeFormatter.format(dueTimeFinish)
            if (taskItem == null){
                val newTask = TaskItemBD(name, desc, date, dueTimeStart!!, dueTimeFinish,null)
                taskViewModel.addTaskItem(newTask)
            }else{
                taskItem!!.name = name
                taskItem!!.desc = desc
                taskItem!!.date = date
                taskItem!!.dueTimeStart = dueTimeStart!!
                taskItem!!.dueTimeFinish = dueTimeFinish
                taskViewModel.updateTaskItem(taskItem!!)
            }
            //binding.dateString.text = ""
            binding.name.setText("")
            binding.desc.setText("")
            dismiss()
        }catch (e:Exception){
            Toast.makeText(requireContext(), "Choose a time to start", Toast.LENGTH_LONG).show()
        }

    }
}