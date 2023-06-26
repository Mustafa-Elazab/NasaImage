package com.mostafa.data.remote.paging

import android.net.Uri
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.mostafa.data.local.database.AppDatabase
import com.mostafa.data.local.entity.NasaImageEntity
import com.mostafa.data.mapping.toNasaEntity
import com.mostafa.data.mapping.toNasaModel
import com.mostafa.data.remote.api.ApiServices
import com.mostafa.data.remote.dto.NasaLinkDTO
import retrofit2.HttpException
import java.io.IOException


@OptIn(ExperimentalPagingApi::class)
class NasaRemoteMediator(
    private val api: ApiServices,
    private val appDatabase: AppDatabase,
    private val q: String?
) : RemoteMediator<Int, NasaImageEntity>() {
    private var nextPage: Int? = 1

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, NasaImageEntity>
    ): MediatorResult {
        return try {
            val page = when (loadType) {
                LoadType.REFRESH -> {
                    nextPage = 1
                    null
                }

                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    if (nextPage == null) {
                        return MediatorResult.Success(endOfPaginationReached = true)
                    }
                    nextPage
                }
            }

            val response = api.getSearchResult(q, page ?: 1, state.config.pageSize)

            appDatabase.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    appDatabase.nasaImageDao().clearNasaImages()
                }

                val entities = response.collection.items.map { it.toNasaModel() }
                appDatabase.nasaImageDao().insertNasaImages(entities.map { it.toNasaEntity() })

                nextPage = getNextPage(response.collection.links)
            }

            MediatorResult.Success(endOfPaginationReached = response.collection.items.isEmpty())
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }



    private fun getNextPage(links: List<NasaLinkDTO>): Int? {
        val nextLink = links.firstOrNull { it.rel == "next" }
        val href = nextLink?.href ?: return null
        val uri = Uri.parse(href)
        val pageQuery = uri.getQueryParameter("page")
        return pageQuery?.toIntOrNull()
    }

}





