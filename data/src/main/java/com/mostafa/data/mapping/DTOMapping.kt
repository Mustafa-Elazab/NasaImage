package com.mostafa.data.mapping

import com.mostafa.data.remote.dto.NasaItemDTO
import com.mostafa.domain.model.NasaModel


fun NasaItemDTO.toNasaModel() = NasaModel(
    center = data.firstOrNull()?.center,
    title = data.firstOrNull()?.title,
    nasaId = data.firstOrNull()?.nasaId,
    dateCreated = data.firstOrNull()?.dateCreated,
    mediaType = data.firstOrNull()?.mediaType,
    description = data.firstOrNull()?.description,
    thumbnailUrl = links.firstOrNull { it.rel == "preview" && it.render == "image" }?.href,

)










