package com.zibran.brutoapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zibran.brutoapp.data.local.BorutoDatabase
import com.zibran.brutoapp.data.paging_source.HeroRemoteMediator
import com.zibran.brutoapp.data.paging_source.SearchHeroSource
import com.zibran.brutoapp.data.remote.BorutoApi
import com.zibran.brutoapp.domain.model.Hero
import com.zibran.brutoapp.domain.repository.RemoteDataSource
import com.zibran.brutoapp.utils.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(
    private val borutoApi: BorutoApi,
    private val borutoDatabase: BorutoDatabase
) : RemoteDataSource {
    private val heroDao = borutoDatabase.heroDao()
    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                borutoApi = borutoApi,
                borutoDatabase = borutoDatabase
            ), pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchHeroSource(
                    borutoApi = borutoApi,
                    query = query
                )
            }
        ).flow
    }
}