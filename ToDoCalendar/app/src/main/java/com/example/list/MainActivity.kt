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
            setRecyclerView()
            Log.e("клик календарь $currentDate", "")
        }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        taskViewModel.taskItems.observe(this) {list ->
            binding.recyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(list.filter {
                        it.date == currentDate
                }, this@MainActivity)
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











