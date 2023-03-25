package com.example.myapplication


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel (private val wordDao: WordDao): ViewModel()  {

    private var _stateButton = MutableStateFlow(false)    // в этом параметре хранится состояние для кнопки
     val stateButton = _stateButton.asStateFlow()

    fun setStateButton(value: Boolean){         //передаем значение состояния кнопки
        _stateButton.value = value
    }

    val allWords = this.wordDao.getAll()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )

    var count: Int = 1 + allWords.value.size

   /* fun onRead(words: String ){
        viewModelScope.launch {
            val list = wordDao.getListAll()
            var newWords = Words(words, 1)
                list.forEach {
                    if (it.words == words){
                        newWords = it.apply { count++ }
                        wordDao.update(it)
                        return@launch      //если находит значение, то делает обновление счетчика и выходит
                    }
                }
                wordDao.insert(newWords)     // выходим сюда, когда ничего не нашли в списке и записываем новое слово

                                            /* wordDao.getAll().collect{                        //так не нужно, неправильные типы
                                                if (allWords.value.toString() == words){
                                                    onUpdate(words)
                                                }else{
                                                    onAdd(words)
                                                }*/

        }
    }*/

     fun read (words: String){
         viewModelScope.launch {
             val findWord = wordDao.findByWord(words)               // ищем слово
             if (findWord == null ){                                // если не нашли то добавляем в БД через insert
                 Log.d("SAVE_BD", "findWord == null")
                 wordDao.insert(
                     Words(
                         words = words,
                         count = count
                     )
                 )
             }else{                                                 // если нашли, то увеличиваем  count
                 findWord.apply { count++ }
                 wordDao.update(findWord)
                 Log.d("SAVE_BD", " findWord == $findWord ")

             }
         }
    }

    fun onDeleteBtn() {
            viewModelScope.launch {
                allWords.value.lastOrNull()?.let{wordDao.deleteAll()}
                //allWords.drop(allWords.value.size)
            }
    }
}