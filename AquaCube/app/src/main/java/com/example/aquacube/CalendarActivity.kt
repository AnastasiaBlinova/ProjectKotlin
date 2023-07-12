package com.example.aquacube

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.compose.runtime.traceEventEnd
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aquacube.adapter.ItemAdapter
import com.example.aquacube.databinding.ActivityCalendarBinding
import com.example.aquacube.model.Item
import com.example.aquacube.model.User
import com.example.aquacube.viewModel.DateViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CalendarActivity : AppCompatActivity() {
    var binding: ActivityCalendarBinding? = null

    val dateFormat = SimpleDateFormat("dd.MM.yyyy")
    var currentDate = dateFormat.format(Date())

    private val dateViewModel: DateViewModel by viewModels()

    lateinit var recyclerView: RecyclerView
    var itemList: ArrayList<Item>? = null
    var itemAdapter: ItemAdapter? = null
    lateinit var bd: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.message.text = currentDate

        bd = FirebaseFirestore.getInstance()
        itemList = ArrayList()
        itemAdapter = ItemAdapter(this,itemList)
        recyclerView = binding!!.recyclerView
 //       recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter
        showDate()

//        bd.collection("Documents")
//            .document()
//            .set(itemList!!)
//       //     .get()
//            .addOnSuccessListener {
//
//            }
//            .addOnFailureListener {
//
//            }
//        bd.collection("Documents")
//            .get()
//            .addOnCompleteListener { object: ValueEventListener {
//            @SuppressLint("NotifyDataSetChanged")
//            override fun onDataChange(snapshot: DataSnapshot) {
//                itemList!!.clear()
//                for (snapshot1 in snapshot.children){
//                    val item: Item? = snapshot1.getValue(Item::class.java)
//     //               if (item!!.name?.equals(FirebaseFirestore.getInstance()) == true)
//                        itemList!!.add(item!!)
//                }
//                itemAdapter!!.notifyDataSetChanged()
//            }
//            override fun onCancelled(error: DatabaseError) {}
//
//        }
//        showDate()
        //binding!!.recyclerView.adapter = ItemAdapter(this,itemList)

        binding!!.newTaskButton.setOnClickListener {
            dateViewModel.setData(currentDate)
            val intent = Intent(this@CalendarActivity, DealDetailsFragment::class.java)
            intent.putExtra("date", binding?.message?.text.toString())
            startActivity(intent)
            finishAffinity()
           // DealDetailsFragment(/*null*/).show(supportFragmentManager, "newTaskTag" )
        }

        binding!!.chat.setOnClickListener {
            val intent = Intent(this@CalendarActivity, PeopleActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding!!.outButton.setOnClickListener {
            val intent = Intent(this@CalendarActivity, VerificationActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding!!.calendar.setOnDateChangeListener {view, year, month, dayOfMonth ->
            val changeD: String
            val changeM: String
            if ((month+1).toString().length < 2 )
                changeM = "0${month+1}"
            else changeM = "${month+1}"
            if (dayOfMonth.toString().length < 2 )
                changeD = "0$dayOfMonth"
            else changeD = "$dayOfMonth"
            currentDate = "$changeD.$changeM.$year"
            binding!!.message.text = currentDate

 //           showDate()
      //      setRecyclerView()
        }

     //   setRecyclerView()
    }
//    fun readFireStore(){
//        val dbFirestore = FirebaseFirestore.getInstance()
//        dbFirestore.collection("Documents")
//            .get()
//            .addOnCompleteListener {
//                val result = StringBuffer()
//                if (it.isSuccessful){
//                    for (document in it.result!!){
//                        result.append(document.data.getValue("name")).append("")
//                        result.append(document.data.getValue("count")).append("")
//                        result.append(document.data.getValue("time")).append("")
//                    }
//                    recyclerView.setT
//                }
//            }
//    }


   fun showDate() {
       bd.collection("Documents")
           .get()
           .addOnCompleteListener {
               object : ValueEventListener {
                   @SuppressLint("NotifyDataSetChanged")
                   override fun onDataChange(snapshot: DataSnapshot) {
                       itemList!!.clear()
                       for (snapshot1 in snapshot.children) {
                           val item: Item? = snapshot1.getValue(Item::class.java)
                           //               if (item!!.name?.equals(FirebaseFirestore.getInstance()) == true)
                           itemList!!.add(item!!)
                       }
                       itemAdapter!!.notifyDataSetChanged()
                   }

                   override fun onCancelled(error: DatabaseError) {}

               }
           }
//
//        bd.collection("Documents")
//            //.whereGreaterThan("date", currentDate)
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    Log.e(TAG, "${document.id} => ${document.data}")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.e(TAG, "Error getting documents.", exception)
//            }

//        bd.collection(COLLECTION).get().addOnSuccessListener { result ->
//            alStudent.clear()
//            for (doc in result){
//                val hm = kotlin.collections.HashMap<String, String>()
//                hm.set(F_ID, doc.get("id").toString())
//                hm.set(F_NAME, doc.get("name").toString())
//                hm.set(F_ADDRESS, doc.get("address").toString())
//                hm.set(F_PHONE, doc.get("phone").toString())
//                alStudent.add(hm)
//            }
//            adapter = SimpleAdapter(this, alStudent, R.layout.task_item,
//                arrayOf(F_ID, F_NAME, F_ADDRESS,F_PHONE),
//                intArrayOf(R.id.)
//            )
//        }
   }
}