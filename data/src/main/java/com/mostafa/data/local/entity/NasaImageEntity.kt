package com.mostafa.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "nasa_images")
data class NasaImageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val center: String?,
    val title: String?,

    @ColumnInfo(name = "nasa_id")
    val nasaId: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
    @ColumnInfo(name = "media_type")
    val mediaType: String?,
    val description: String?,
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String?,

    )
