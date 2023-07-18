package com.zibran.brutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zibran.brutoapp.data.local.dao.HeroDao
import com.zibran.brutoapp.data.local.dao.HeroRemoteKeyDao
import com.zibran.brutoapp.domain.model.Hero
import com.zibran.brutoapp.domain.model.HeroRemoteKeys

@TypeConverters(DatabaseConverter::class)
@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
abstract class BorutoDatabase: RoomDatabase() {

    abstract fun heroDao():HeroDao
    abstract fun heroRemoteKeysDao():HeroRemoteKeyDao
}