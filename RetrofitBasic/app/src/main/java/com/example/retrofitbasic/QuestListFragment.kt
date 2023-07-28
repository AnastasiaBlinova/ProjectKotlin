package com.example.retrofitbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider


class QuestListFragment : Fragment(R.layout.fragment_quest_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val questListViewModel = ViewModelProvider(this).get(QuestListViewModel::class.java)
    }

}