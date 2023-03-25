package com.example.myapplication


import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Transaction
    @Query("SELECT * " +
            "FROM list " +
            "order by count desc "+
            "limit 5")
    //@Query("select words, count() as count "+
    //        "FROM list " +
    //        "group by words " +
    //        "having count() >=1 " +
    //        "order by count desc " +
    //        "limit 5")
    fun getAll(): Flow<List<Words>>   // для получения всего списка;  Flow позволяет получать данные об обновлениях

    @Insert(onConflict = OnConflictStrategy.REPLACE)            //(entity = Words::class)
    suspend fun insert(words: Words)       // для получения ставки

   /* @Query("SELECT * " +
            "FROM list ")
    suspend fun getListAll(): List<Words>   // добавляем, для работы со списком слов, если использ ф-ю onRead
*/
   @Query("SELECT * " +
            "FROM list WHERE words LIKE:word ")
    suspend fun findByWord(word: String): Words? //List<Words> нет смысла в списке, так как элементов будет 0 или 1

    //@Delete
    @Query("delete from list ")
    suspend fun deleteAll()      // для удаления одного  (words: Words)

    @Update
    suspend fun update(words: Words)       // для обновления
}