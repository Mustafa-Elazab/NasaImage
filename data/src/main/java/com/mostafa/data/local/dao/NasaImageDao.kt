package com.mostafa.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mostafa.data.local.entity.NasaImageEntity


@Dao
interface NasaImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNasaImages(images: List<NasaImageEntity>)

    @Query("DELETE FROM nasa_images")
    suspend fun clearNasaImages()

    @Query("SELECT * FROM nasa_images ORDER BY nasa_id ASC")
    fun getNasaImages(): PagingSource<Int, NasaImageEntity>


}


