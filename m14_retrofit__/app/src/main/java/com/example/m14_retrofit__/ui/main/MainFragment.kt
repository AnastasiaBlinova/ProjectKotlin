package com.example.m14_retrofit__.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.m14_retrofit__.R
import com.example.m14_retrofit__.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment() {companion object {
    fun newInstance() = MainFragment()
}

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()    //после немного меняем логику в
    // MainViewModel и добавляем обращение к репозиторию


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.reloadPerson()

        binding.button.setOnClickListener {
            binding.nameTitle.text = ""
            binding.name.text = ""
            binding.city.text = ""
            binding.age.text = ""
            binding.country.text = ""
            binding.email.text = ""
            binding.image.isVisible = true

            viewModel.reloadPerson()

        }

       viewLifecycleOwner.lifecycleScope.launchWhenStarted {
           viewModel.personModel.collect{ person ->
               val result = person.results[0]
                binding.nameTitle.text = result.name.title
                binding.name.text = "${result.name.first} ${result.name.last}"
               val city = result.location.city
                binding.city.text = city
                binding.age.text = result.dob.age.toString()
               val country = result.location.country
                binding.country.text = country
               val email= result.email
                binding.email.text = email
               val url = result.picture.large //"https://randomuser.me/api/?results=1&inc=picture"
               Glide.with(requireContext())
                   .load(url)
                   .into(binding.image)
           }
       }
        viewLifecycleOwner.lifecycleScope        //viewLifecycleOwner отвечает за жизненный цикл вью фрагмент и не даст выполнится коду когда это не нужно или когда даст ошибку
            .launchWhenStarted {                 // lifecycleScope  скоуп для запуска корунтин;  launchWhenStarted- запускает при состоянии не ниже стартового
                viewModel.state                  //ПОДПИСЫВАЕМСЯ НА ИЗМЕНЕНИя
                    .collect{ state ->
                        when (state){
                            State.Start -> {                    // Экран при запуске приложения
                                binding.progressBar.isVisible = false
                            }
                            State.Loading -> {                 // Экран во время иммитации поиска
                                binding.progressBar.isVisible = true
                                binding.image.isVisible = false
                            }
                            State.Result -> {                   // Экран после окончания поиска
                                binding.progressBar.isVisible = false
                                binding.image.isVisible = true
                            }
                            is State.Error -> {                 // Экран на случай ошибки
                                binding.progressBar.isVisible = false
                                binding.name.text = "NOT FOUND"
                                binding.image.setImageResource(R.drawable.ic_launcher_background)
                            }
                        }
                    }
            }
        viewLifecycleOwner.lifecycleScope        //viewLifecycleOwner отвечает за жизненный цикл вью фрагмент и не даст выполнится коду когда это не нужно или когда даст ошибку
            .launchWhenStarted {
                viewModel.error
                    .collect{ message->
                        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
                    }
            }
    }
}
