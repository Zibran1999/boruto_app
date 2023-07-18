package com.zibran.brutoapp.data.repository

import com.zibran.brutoapp.data.local.BorutoDatabase
import com.zibran.brutoapp.domain.model.Hero
import com.zibran.brutoapp.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase) : LocalDataSource {
    private val heroDao = borutoDatabase.heroDao()
    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}