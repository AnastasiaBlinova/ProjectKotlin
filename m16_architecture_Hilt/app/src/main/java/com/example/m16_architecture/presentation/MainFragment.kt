package com.example.m16_architecture.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.m16_architecture.R
import com.example.m16_architecture.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val viewModel: MainViewModel by viewModels { mainViewModelFactory
        //DaggerAppComponent.create().injectMainFragment()
    }

    private val binding get() = _binding!!           // *сделаем бандинг общим
    private var _binding: FragmentMainBinding? = null

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        //App.component.injectMainFragment(this)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            binding.stringWithActivity.text = ""
            viewModel.reloadUsefulActivity()
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.activityModel.collect{ activity ->
                binding.stringWithActivity.text = activity.activity
            }
        }
        viewLifecycleOwner.lifecycleScope        //viewLifecycleOwner отвечает за жизненный цикл вью фрагмент и не даст выполнится коду когда это не нужно или когда даст ошибку
            .launchWhenStarted {                 // lifecycleScope  скоуп для запуска корунтин  launchWhenStarted- запускает при состоянии не ниже стартового
                viewModel.state                  //ПОДПИСЫВАЕМСЯ НА ИЗМЕНЕНИя
                    .collect { state ->
                        when (state) {
                            State.Start -> {
                                binding.progressBar.isVisible = false
                                binding.button.isVisible = true
                            }
                            State.Loading -> {
                                binding.progressBar.isVisible = true
                                binding.button.isVisible = false
                            }
                            is State.Result -> {
                                binding.button.isVisible = true
                                binding.progressBar.isVisible = false
                            }
                            is State.Error -> {
                                binding.stringWithActivity.text = getString(R.string.feed_your_cat)
                                binding.progressBar.isVisible = false
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