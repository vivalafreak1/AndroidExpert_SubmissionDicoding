package com.arieftaufikrahman.wibuapp.core.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.arieftaufikrahman.wibuapp.core.domain.model.Data

class AnimePagingSource(
    private val animeApi: AnimeApi,
    private val data: String
): PagingSource<Int, Data>() {

    private var totalAnimeCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val page = params.key ?: 1
        return try {
            val animeResponse = animeApi.getSeasonNow(/*data = data,*/ page = page)
            totalAnimeCount += animeResponse.data.size
            val data = animeResponse.data.distinctBy {
                it.title
            }
            LoadResult.Page(
                data = data,
                nextKey = if (totalAnimeCount == animeResponse.pagination.items.total) null else page + 1,
                prevKey = null
            )
        } catch (e:Exception) {
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, com.arieftaufikrahman.wibuapp.core.domain.model.Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}