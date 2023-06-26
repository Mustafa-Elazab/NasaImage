package com.mostafa.nasaimage.cycles.home_cycle.fragment.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mostafa.domain.model.NasaModel
import com.mostafa.domain.usecase.GetSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCase: GetSearchUseCase) : ViewModel() {

    private val _searchResults = MutableStateFlow<PagingData<NasaModel>?>(null)
    val searchResults get() = _searchResults.asStateFlow()

    private val _validationState = MutableSharedFlow<ValidationErrors>()
    val validationState get() = _validationState.asSharedFlow()

    private var currentSearchQuery: String? = null

    init {
        observeSearchResults()
    }

    private fun observeSearchResults() {
        viewModelScope.launch {
            useCase(currentSearchQuery).let { pagingData ->
                pagingData.cachedIn(viewModelScope).collectLatest { data ->
                    _searchResults.value = data
                }
            }
        }
    }

    suspend fun validateText(text: String) {
        if (text.isEmpty()) {
            _validationState.emit(ValidationErrors.TEXT)
        } else {
            currentSearchQuery = text
            observeSearchResults()
        }
    }
}
enum class ValidationErrors {
    TEXT
}
