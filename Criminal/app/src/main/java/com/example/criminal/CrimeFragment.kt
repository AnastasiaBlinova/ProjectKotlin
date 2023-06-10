package com.example.criminal

import android.os.Bundle
import androidx.fragment.app.Fragment

class CrimeFragment: Fragment() {
    private lateinit var crime: CrimeData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = CrimeData()
    }
}