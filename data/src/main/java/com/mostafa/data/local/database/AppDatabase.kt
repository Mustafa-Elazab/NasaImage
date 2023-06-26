package com.mostafa.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mostafa.data.local.converter.Converters
import com.mostafa.data.local.dao.NasaImageDao
import com.mostafa.data.local.entity.NasaImageEntity


@Database(
    entities = [NasaImageEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun nasaImageDao(): NasaImageDao

}