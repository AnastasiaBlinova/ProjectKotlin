package com.example.movielistexample.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.movielistexample.databinding.FragmentMovieListBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MovieListFragment : Fragment() {
    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MovieListViewModel by viewModels()

    private val movieAdapter = MovieAdapter()
    private val movieListAdapter = MovieListAdapter()
    private val pagingDataAdapter = MoviePagingDataAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recycler.adapter = pagingDataAdapter

        viewModel.pagedMovies.onEach {
            pagingDataAdapter.submitData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

//        binding.recycler.adapter = movieListAdapter
//
//        viewModel.movies.onEach {
//  //          movieAdapter.setData(it)
//            movieListAdapter.submitList(it)
//        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}