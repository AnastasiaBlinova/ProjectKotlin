package com.example.movielistexample.pagedmovielist

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movielistexample.models.Movie
import com.example.movielistexample.movielist.MovieListRepository

class MoviePagingSource: PagingSource<Int, Movie>()  {
    private val repository = MovieListRepository()
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? = FIRST_PAGE

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        return kotlin.runCatching {
            repository.getTopList(page)
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
    }
    private companion object {
        private val FIRST_PAGE = 1
    }
}