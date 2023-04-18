package com.example.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DateViewModel : ViewModel(){
    val date = MutableLiveData<String>()

    fun setData(newData: String){
        date.value = newData
    }
}