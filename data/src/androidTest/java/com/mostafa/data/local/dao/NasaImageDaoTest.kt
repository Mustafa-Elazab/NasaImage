package com.mostafa.data.local.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingSource
import androidx.test.filters.SmallTest
import com.mostafa.data.local.database.AppDatabase
import com.mostafa.data.local.entity.NasaImageEntity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi
@SmallTest
@HiltAndroidTest
class NasaImageDaoTest{

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("test_database")
    lateinit var database: AppDatabase

    private lateinit var dao: NasaImageDao

    @Before
    fun setup() {
        hiltRule.inject()
        dao = database.nasaImageDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun test_insert_get_nasa_image_then_return_true() = runBlockingTest {
        val request = createSampleResponse()
        val expectedList = listOf(request)

        dao.insertNasaImages(expectedList)

        val actualList = dao.getNasaImages()


        Assert.assertEquals(expectedList, actualList)
    }


    private fun createSampleResponse(): NasaImageEntity {
        return NasaImageEntity(id = 0,center = "",title = "",nasaId = "",
            dateCreated = "",mediaType = "",description = "", thumbnailUrl = "")
    }


}