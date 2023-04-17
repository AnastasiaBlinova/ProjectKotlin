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
    private var dateString: String? = null
    val dateFormat = SimpleDateFormat("dd.MM.yyyy")

    private lateinit var binding: ActivityMainBinding

    private val taskViewModel: TaskViewModel by viewModels {
        TaskItemModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currentDate = dateFormat.format(Date())
        binding.message.text = currentDate

        binding.newTaskButton.setOnClickListener{
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
            //val date = "$dayOfMonth-${month + 1}-$year"
            val date = "$changeD.$changeM.$year"
            binding.message.text = date //"$dayOfMonth.${month + 1}.$year"
            dateString = date
        }
       /* binding.newTaskButton.setOnClickListener{
            val bundle = Bundle().apply {
                putString("date", dateString)
                //putString("param3", answer2)
            }
            Log.e("!!!", "$dateString, $bundle")
            //DealDetailsFragment(null).show(parentFragmentManager, "newTaskTag")
            //.findNavController().navigate(R.id.action_mainFragment_to_dealDetailsFragment, args = bundle)

            //findNavController().navigate(R.id.action_mainFragment_to_dealDetailsFragment, args = bundle)

        }*/
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val mainActivity = this
        taskViewModel.taskItems.observe(this) {
            binding.recyclerView.apply {
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











