package com.zibran.brutoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zibran.brutoapp.utils.Constants.HERO_REMOTE_KEYS_DATABASE_TABLE

@Entity(tableName = HERO_REMOTE_KEYS_DATABASE_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated:Long?

)