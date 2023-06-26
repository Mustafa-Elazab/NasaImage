package com.mostafa.domain.usecase

import androidx.paging.PagingData
import com.mostafa.domain.model.NasaModel
import com.mostafa.domain.repository.NasaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSearchUseCase @Inject constructor(private val repository: NasaRepository) {

    operator fun invoke(query: String?): Flow<PagingData<NasaModel>> {
        return repository.getNasaImages(query)
    }
}