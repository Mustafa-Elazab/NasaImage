package com.mostafa.domain.repository

import androidx.paging.PagingData
import com.mostafa.domain.model.NasaModel
import kotlinx.coroutines.flow.Flow

interface NasaRepository {


    fun getNasaImages(q: String?): Flow<PagingData<NasaModel>>

}