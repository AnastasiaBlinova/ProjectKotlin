package com.example.m17_recyclerview.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.m17_recyclerview.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModel by activityViewModels()

    private var photoSrc = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        photoSrc = arguments?.getString(FirstFragment.KEY_POSITION) ?: ""
        Log.e("HHHH", "SecondFragment pos = $photoSrc")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // val photoSrc = viewModel.photos.value[position].imgSrc
        Glide.with(requireContext())
            .load(photoSrc)
            .into(binding.photoSputnik)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

