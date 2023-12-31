package com.mostafa.nasaimage.cycles.home_cycle.fragment.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import com.mostafa.domain.model.NasaModel
import com.mostafa.domain.repository.NasaRepository
import com.mostafa.domain.usecase.GetSearchUseCase
import com.mostafa.nasaimage.MainCoroutineRule
import io.mockk.impl.annotations.MockK
import io.mockk.mockk

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {


    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutine = MainCoroutineRule()

    val useCase = mockk<GetSearchUseCase>()

    private lateinit var homeViewModel: HomeViewModel


    @Before
    fun setup() {
        homeViewModel = HomeViewModel(useCase = useCase)
    }

    @Test
    fun validateText_withNonEmptyText_shouldUpdateSearchResults() = runTest{
        // Given
        val expectedPagingData = createMockPagingData()
        val text = "example"

       `when`(useCase.invoke(text)).thenReturn(flowOf(expectedPagingData))


        // Act
        val result = useCase.invoke(text).single()

        // Assert
        assertEquals(expectedPagingData, result)

        verify(useCase).invoke(text)
    }


    @Test
    fun validateText_withEmptyText_shouldEmitValidationState() = runTest {
        // Given
        val expectedValidationState = ValidationErrors.TEXT
        val text = ""

        // When
        homeViewModel.validateText(text)

        // Then
        val actualValidationState = homeViewModel.validationState.first()
        Assert.assertEquals(expectedValidationState, actualValidationState)
    }

    private fun createMockPagingData(): PagingData<NasaModel> {
        return PagingData.empty()
    }
}

