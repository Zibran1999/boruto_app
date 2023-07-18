package com.zibran.brutoapp.di

import android.content.Context
import androidx.room.Room
import com.zibran.brutoapp.data.local.BorutoDatabase
import com.zibran.brutoapp.data.repository.LocalDataSourceImpl
import com.zibran.brutoapp.domain.repository.LocalDataSource
import com.zibran.brutoapp.utils.Constants.BORUTO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BorutoDatabase {
        return Room.databaseBuilder(
            context,
            BorutoDatabase::class.java,
            BORUTO_DATABASE
        ).build()

    }

    @Provides
    @Singleton
    fun provideLocalDataSource(borutoDatabase: BorutoDatabase): LocalDataSource {
        return LocalDataSourceImpl(borutoDatabase = borutoDatabase)
    }
}