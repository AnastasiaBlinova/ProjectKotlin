package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val wordDao: WordDao = (application as App).db.wordDao()
                return MainViewModel(wordDao) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val wordDao: WordDao = (application as App).db.wordDao()
        val inputText = binding.editText.text.toString()

        val pattern = "^[A-Za-z-]*\$".toRegex()             //|[А-Яа-яЁё]|[-]^[0-9]   эти символы нужно вводить с клавиатуры
        binding.editText.addTextChangedListener {
            if (it != null){
                val p = it.matches(pattern)                 // проверка введенных символов на условие //containsMatchIn
                if (p){                                     // значение Р true or false
                    viewModel.setStateButton(it.length > 3)
                } else{
                    Toast.makeText(this, "Error format text", Toast.LENGTH_SHORT).show()
                }
                //вызываем функцию для проверки состояния кнопки, передав в функцию введенную строки
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.stateButton.collect{
                binding.addBtn.isEnabled = it
            }
        }

        binding.addBtn.setOnClickListener {
            viewModel.read(binding.editText.text.toString())

            binding.deleteBtn.setOnClickListener { viewModel.onDeleteBtn() }

            lifecycleScope.launchWhenCreated {
                viewModel.allWords
                    .collect { words ->
                        binding.textView
                            .text = words.joinToString(
                            separator = "\r\n"
                        )
                    }
            }
        }
    }
}