package com.mostafa.data.remote.dto

import com.google.gson.annotations.SerializedName

data class NasaDTO(
    @SerializedName("collection")
    val collection: NasaCollectionDTO
)

data class NasaCollectionDTO(
    @SerializedName("items")
    val items: List<NasaItemDTO>,
    @SerializedName("metadata")
    val metadata: NasaMetadataDTO,
    @SerializedName("links")
    val links: List<NasaLinkDTO>
)

data class NasaItemDTO(
    @SerializedName("data")
    val data: List<NasaDataDTO>,
    @SerializedName("links")
    val links: List<NasaLinkDTO>
)

data class NasaDataDTO(
    @SerializedName("center")
    val center: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("keywords")
    val keywords: List<String>?,
    @SerializedName("nasa_id")
    val nasaId: String?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("media_type")
    val mediaType: String?,
    @SerializedName("description")
    val description: String?
)

data class NasaMetadataDTO(
    @SerializedName("total_hits")
    val totalHits: Int?
)

data class NasaLinkDTO(
    @SerializedName("href")
    val href: String?,
    @SerializedName("rel")
    val rel: String?,
    @SerializedName("prompt")
    val prompt: String?,
    @SerializedName("render")
    val render: String?
)
