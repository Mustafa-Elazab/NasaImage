package com.mostafa.data.di

import android.content.Context
import androidx.room.Room
import com.mostafa.data.local.dao.NasaImageDao
import com.mostafa.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideNasaImageDao(appDatabase: AppDatabase): NasaImageDao = appDatabase.nasaImageDao()




    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app-db"
        ).build()


}