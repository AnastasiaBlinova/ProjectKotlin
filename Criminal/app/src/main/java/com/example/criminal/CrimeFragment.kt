package com.example.criminal

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class CrimeFragment: Fragment() {
    private lateinit var crime: CrimeData
    private lateinit var titleField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = CrimeData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object: TextWatcher{             //  СОЗДАЕМ АНОНИМНЫЙ КЛАСС
            override fun beforeTextChanged(                 // КОТОРЫЙ РЕАЛИЗУЕТ ИНТЕРФЕЙС
                sequence: CharSequence?,                    // СЛУШАТЕЛЯ TextWatcher
                start: Int,
                count: Int,
                after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(                 // ЭТА ФУНКЦИЯ ВОЗВРАЩАЕТ СТРОКУ
                sequence: CharSequence?,                // КОТОРАЯ ПОТОМ ИСПОЛЬЗУЕТСЯ
                start: Int,                             // ДЛЯ ЗАДАНИЯ ЗАГОЛОВКА cRIME
                before: Int,
                count: Int) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
                TODO("Not yet implemented")
            }

        }
        titleField.addTextChangedListener(titleWatcher)
    }

}