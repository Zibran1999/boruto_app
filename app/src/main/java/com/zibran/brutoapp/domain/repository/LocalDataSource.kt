package com.zibran.brutoapp.domain.repository

import com.zibran.brutoapp.domain.model.Hero

interface LocalDataSource {

    suspend fun getSelectedHero(heroId: Int): Hero
}