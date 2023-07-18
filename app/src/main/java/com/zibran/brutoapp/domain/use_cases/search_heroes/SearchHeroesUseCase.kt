package com.zibran.brutoapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.zibran.brutoapp.data.repository.Repository
import com.zibran.brutoapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {

    operator fun invoke(query: String): Flow<PagingData<Hero>> {
        return repository.searchHero(query = query)
    }
}