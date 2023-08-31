package com.example.m17_recyclerview.presentation

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.m17_recyclerview.data.Repository
import com.example.m17_recyclerview.domain.Photos

class PagginSource: PagingSource<Int, Photos>() {

    private val repository = Repository()
    override fun getRefreshKey(state: PagingState<Int, Photos>): Int = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photos> {
        //основная функция для загрузки данных, она будет вызываться когда нужно
        // дополнительно загрузить данные

// ****** ТЕСТИЛА Для ПОСТРАНИЧНОЙ ЗАГРУЗКИ

        val page = params.key ?: FIRST_PAGE
        return kotlin.runCatching {
            repository.getPhotoSputnik(page)
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = null,
                    nextKey = if (it.isEmpty()) null else page + 1
                )
            },
            onFailure = {LoadResult.Error(it)}
        )

//        TODO("Not yet implemented")
    }

    private companion object {
        private val FIRST_PAGE = 1
    }

}