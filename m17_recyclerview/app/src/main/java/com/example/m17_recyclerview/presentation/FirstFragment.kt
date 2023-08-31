package com.example.m17_recyclerview.presentation

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.m17_recyclerview.R
import com.example.m17_recyclerview.databinding.FragmentFirstBinding
import com.example.m17_recyclerview.sputnik_photo_list.Adapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

private const val ARG_PARAM1 = "photo"

class FirstFragment : Fragment() {

    private var param: String? = null
    private var position: Int? = null

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModel by activityViewModels()


    private val photoSputnikAdapter = Adapter {position -> onClick(position)}
    companion object {
        const val  KEY_POSITION = "key_position"
        fun newInstance() = FirstFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getString(ARG_PARAM1)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        App.component.injectMainFragment(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.recycler.adapter = photoSputnikAdapter
        viewModel.pagedSputnik.onEach {                  // + 3 (Paging) постраничной
            photoSputnikAdapter.submitData(it)           // + 3 (Paging) загрузки
        }.launchIn(viewLifecycleOwner.lifecycleScope)    //  + 3 (Paging) данных

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recycler.adapter = photoSputnikAdapter

//        viewModel.photos.onEach {                                         // 1 (PhotoSputnik)
//            if (!it.isEmpty()){ // если не пустой, то отгрузи в адаптер   // 1 (PhotoSputnik)
//                photoSputnikAdapter.setData(it[0].photos)                 // 1 (PhotoSputnik)
//            }                                                             // 1 (PhotoSputnik)
//        }.launchIn(viewLifecycleOwner.lifecycleScope)                     // 1 (PhotoSputnik)

// ****** ТЕСТИЛА Для ПОСТРАНИЧНОЙ ЗАГРУЗКИ

//        viewModel.photos.onEach {                                         // 2 (List<Photos>)
//            if (!it.isEmpty()){ // если не пустой, то отгрузи в адаптер   // 2 (List<Photos>)
//                photoSputnikAdapter.setData(it)                           // 2 (List<Photos>)
//            }                                                             // 2 (List<Photos>)
//        }.launchIn(viewLifecycleOwner.lifecycleScope)                     // 2 (List<Photos>)

        viewModel.pagedSputnik.onEach {                  // + 3 (Paging) постраничной
            photoSputnikAdapter.submitData(it)           // + 3 (Paging) загрузки
        }.launchIn(viewLifecycleOwner.lifecycleScope)    //  + 3 (Paging) данных

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//       private fun onClick(position: Int){                                                                    // 1 (PhotoSputnik)
//        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)                             // 1 (PhotoSputnik)
//        Log.d("HHHH", "position $position") //проверка позиции                                                // 1 (PhotoSputnik)
//        Log.d("HHHH", "position ${viewModel.photos.value[0].photos[position]}")// проверкка элемента          // 1 (PhotoSputnik)
//        Log.d("HHHH", "position ${viewModel.photos.value[0].photos[position].imgSrc}") // сылка на фотографию // 1 (PhotoSputnik)
//        viewModel.photo = viewModel.photos.value[0].photos[position].imgSrc                                   // 1 (PhotoSputnik)
//    }

// ****** ТЕСТИЛА Для ПОСТРАНИЧНОЙ ЗАГРУЗКИ

    private fun onClick(position: Int){                                                                         // 2 (List<Photos>)

        val photoSrc = photoSputnikAdapter.snapshot().items[position].imgSrc
 //*       val bundle = Bundle().apply { bundleOf("KEY_POS" to photoSrc) }
        val bundle = Bundle()
        bundle.putString(KEY_POSITION, photoSrc)
        Log.e("HHHH", "photoSrc = $photoSrc")
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)                               // 2 (List<Photos>)
//       Log.d("HHHH", "position $position") //проверка позиции                                         // 2 (List<Photos>)
//        Log.d("HHHH", "position ${viewModel.photos.value[position]}")// проверкка элемента             // 2 (List<Photos>)
//        Log.d("HHHH", "position ${viewModel.photos.value[position].imgSrc}") // сылка на фотографию    // 2 (List<Photos>)
//       viewModel.photo = viewModel.photos.value[position].imgSrc/*.value[position].imgSrc*/                                               // 2 (List<Photos>)
    }

}