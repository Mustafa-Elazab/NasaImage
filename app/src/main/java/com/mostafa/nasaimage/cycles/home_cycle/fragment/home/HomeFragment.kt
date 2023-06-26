package com.mostafa.nasaimage.cycles.home_cycle.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import com.mostafa.nasaimage.R
import com.mostafa.nasaimage.base.BaseFragment
import com.mostafa.nasaimage.cycles.home_cycle.adapter.NasaImageAdapter
import com.mostafa.nasaimage.cycles.home_cycle.adapter.NasaImageLoadStateAdapter
import com.mostafa.nasaimage.databinding.FragmentHomeBinding
import com.mostafa.nasaimage.utils.onDone
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val viewMode: HomeViewModel by viewModels()
    val adapter = NasaImageAdapter()
    override val defineBindingVariables: ((FragmentHomeBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
            binding.fragment = this
        }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //viewMode.observeSearchResults()

        binding.etSearch.onDone {
            val text = binding.etSearch.text.toString()
            viewLifecycleOwner.lifecycleScope.launch {
                viewMode.validateText(text)
            }
        }
        collectFlows(listOf(::collectNasaState,::collectValidateState))
        setRVScrollListener()
    }


    private fun setRVScrollListener() {
        binding.rvImages.setHasFixedSize(true)
        binding.rvImages.adapter = adapter.withLoadStateFooter(
            footer = NasaImageLoadStateAdapter { adapter.retry() }
        )
    }

    private suspend fun collectValidateState(){
        viewMode.validationState.collectLatest {
            when(it){
                ValidationErrors.TEXT -> binding.edtSearch.error = "Search Is Empty Try To Write Something"
            }
        }
    }
    private suspend fun collectNasaState() {
        viewMode.searchResults.collectLatest {
            if (it != null) {
                adapter.submitData(it)
            }
        }
    }
}