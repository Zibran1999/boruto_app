package com.zibran.brutoapp.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zibran.brutoapp.domain.model.Hero

@Dao
interface HeroDao {
    @Query("SELECT * FROM HERO_TABLE ORDER BY id ASC")
    fun getAllHeroes(): PagingSource<Int, Hero>

    @Query("SELECT * FROM HERO_TABLE Where id=:heroId")
    fun getSelectedHero(heroId:Int): Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHero(heroes: List<Hero>)

    @Query("DELETE FROM HERO_TABLE")
    suspend fun deleteAllHeroes()
}