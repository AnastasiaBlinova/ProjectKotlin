package com.example.labone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import com.example.labone_.R

private const val INCREMENT: Int = 1
private const val MIN: Int = 0
private const val MAX: Int = 10

open class ActivityThree : AppCompatActivity() {

    private var currentProgress: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)

        val circleProgress = findViewById<ProgressBar>(R.id.BarCircle)
        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
        val finish = findViewById<Button>(R.id.finish)
        val updateProgress = {
            circleProgress.progress = currentProgress}

            buttonPlus.setOnClickListener {
                if (currentProgress < MAX){
                    currentProgress += INCREMENT
                    updateProgress.invoke()
                }
            }

            buttonMinus.setOnClickListener {
                if (currentProgress > MIN){
                    currentProgress -= INCREMENT
                    updateProgress()
                }
            }

           finish.setOnClickListener {
                val intent = Intent(this, ActivityFour::class.java)
                startActivity(intent)
            }
        }
    }


