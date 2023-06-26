package com.mostafa.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.mostafa.data.local.database.AppDatabase
import com.mostafa.data.mapping.toNasaModel
import com.mostafa.data.remote.api.ApiServices
import com.mostafa.data.remote.paging.NasaRemoteMediator
import com.mostafa.domain.model.NasaModel
import com.mostafa.domain.repository.NasaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OptIn(ExperimentalPagingApi::class)
class NasaRepositoryImpl @Inject constructor(
    private val api: ApiServices,
    private val appDatabase: AppDatabase,
) : NasaRepository {


    override fun getNasaImages(q: String?): Flow<PagingData<NasaModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            remoteMediator = NasaRemoteMediator(api, appDatabase, q),
            pagingSourceFactory = { appDatabase.nasaImageDao().getNasaImages() }
        ).flow.map { pagingData ->
            pagingData.map { entity ->
                entity.toNasaModel()
            }
        }
    }


}



