package com.mostafa.data.mapping

import com.mostafa.data.local.entity.NasaImageEntity
import com.mostafa.domain.model.NasaModel

fun NasaModel.toNasaEntity() = NasaImageEntity(
    center = center!!,
    title = title!!,
    nasaId = nasaId!!,
    dateCreated = dateCreated!!,
    mediaType = mediaType!!,
    description = description!!,
    thumbnailUrl = thumbnailUrl!!,

)


fun NasaImageEntity.toNasaModel() = NasaModel(
    center = center!!,
    title = title!!,
    nasaId = nasaId!!,
    dateCreated = dateCreated!!,
    mediaType = mediaType!!,
    description = description!!,
    thumbnailUrl = thumbnailUrl!!,
)
