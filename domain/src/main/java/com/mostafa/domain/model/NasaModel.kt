package com.mostafa.domain.model

import java.io.Serializable


data class NasaModel(
    val center: String?,
    val title: String?,
    val nasaId: String?,
    val dateCreated: String?,
    val mediaType: String?,
    val description: String?,
    val thumbnailUrl: String?,
) : Serializable
