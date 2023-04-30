package com.example.labone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.labone_.R

class ActivityFour : ActivityThree() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)

        val finish = findViewById<Button>(R.id.finish)
        val ok1 = findViewById<Button>(R.id.ok1)
        val ok2 = findViewById<Button>(R.id.ok2)
        val name = findViewById<EditText>(R.id.name)
        val age = findViewById<EditText>(R.id.age)

        val finishName = name.text
        val finishAge = age.text
       /*intent.extras?.get("name")
        startActivity(Intent(applicationContext, ActivityFour::class.java))
*/
        ok1.setOnClickListener {
            if (finishName.isNotBlank()){
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }

        ok2.setOnClickListener {
            if (finishAge.isNotBlank() && finishName.isNotBlank()){
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }

        finish.setOnClickListener {
            if (finishAge.isNotBlank() && finishName.isNotBlank()) {
                val intent = Intent(this, ActivityTwo::class.java)
                startActivity(intent)
            }  else{
                Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }

    }
}