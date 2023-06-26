package com.mostafa.data.remote.api

import com.mostafa.data.remote.dto.NasaDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {


    @GET("search")
    suspend fun getSearchResult(
        @Query("q") q: String? = null,
        @Query("page") page: Int = 1,
        @Query("page_size") page_size: Int = 20,
        @Query("media_type") media_type: String = "image"
    ): NasaDTO
}
