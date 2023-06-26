package com.mostafa.nasaimage.cycles.home_cycle.fragment.detail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.mostafa.domain.model.NasaModel
import com.mostafa.nasaimage.R
import com.mostafa.nasaimage.base.BaseFragment
import com.mostafa.nasaimage.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {


    override val defineBindingVariables: ((FragmentDetailBinding) -> Unit)?
        get() = { binding ->
            binding.lifecycleOwner = viewLifecycleOwner
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
        val data = arguments?.getSerializable("data") as? NasaModel
        if (data != null) {
            initViews(data)
        }


    }

    private fun initViews(data: NasaModel) {
        binding.apply {
            Glide.with(requireContext())
                .load(data.thumbnailUrl)
                .error(R.drawable.ic_launcher_foreground)
                .into(modelThumbnailImg)


            modelTitleTv.text = data.title
            modelDateTv.text = data.dateCreated
            modelDescTv.text = data.description
            modelIdTv.text = data.nasaId
        }
    }

}