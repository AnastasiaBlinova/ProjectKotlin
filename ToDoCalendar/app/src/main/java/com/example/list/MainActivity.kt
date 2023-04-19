package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), TaskItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val taskViewModel: TaskViewModel by viewModels {
        TaskItemModelFactory((application as TodoApplication).repository)
    }
    private val dateViewModel: DateViewModel by viewModels()
    val dateFormat = SimpleDateFormat("dd.MM.yyyy")
    var currentDate = dateFormat.format(Date())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.message.text = currentDate

        binding.newTaskButton.setOnClickListener{
            dateViewModel.setData(currentDate)
            DealDetailsFragment(null).show(supportFragmentManager, "newTaskTag" )
        }
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
            currentDate = "$changeD.$changeM.$year"
            binding.message.text = currentDate
         //   taskViewModel.readDate(currentDate)
            setRecyclerView()
            Log.e("клик календарь $currentDate", "${taskViewModel.readDate(currentDate)}")
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        taskViewModel.readDate(currentDate)
        val mainActivity = this
        taskViewModel.readDate(currentDate)
        taskViewModel.taskItems.observe(this) {
      //      taskViewModel.readDate(currentDate)
            binding.recyclerView.apply {
                taskViewModel.readDate(currentDate)
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it,mainActivity)
            }
        }
    }

    override fun editTaskItem(taskItem: TaskItemBD) {
        DealDetailsFragment(taskItem).show(supportFragmentManager, "newTaskTag")
    }

    override fun completeTaskItem(taskItem: TaskItemBD) {
        taskViewModel.setCompleted(taskItem)
    }
}











