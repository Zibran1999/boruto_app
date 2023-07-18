package com.zibran.brutoapp.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.zibran.brutoapp.data.remote.BorutoApi
import com.zibran.brutoapp.domain.model.Hero

class SearchHeroSource(
    private val borutoApi: BorutoApi,
    private val query: String
) : PagingSource<Int, Hero>() {
    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val response = borutoApi.searchHeroes(name = query)
            val heroes = response.heroes
            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = response.prevPage,
                    nextKey = response.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}