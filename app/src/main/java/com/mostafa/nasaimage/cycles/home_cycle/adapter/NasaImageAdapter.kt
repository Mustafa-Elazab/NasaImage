package com.mostafa.nasaimage.cycles.home_cycle.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mostafa.domain.model.NasaModel
import com.mostafa.nasaimage.R
import com.mostafa.nasaimage.cycles.home_cycle.fragment.home.HomeFragmentDirections
import com.mostafa.nasaimage.databinding.ImageItemLayoutBinding
import java.io.Serializable


class NasaImageAdapter :
    PagingDataAdapter<NasaModel, NasaImageAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.image_item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.nasaModel = getItem(position)

        val bundle = Bundle().apply {
            putSerializable("data", getItem(position) as Serializable)
        }

        holder.itemView.setOnClickListener { view ->
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_homeFragment_to_detailFragment, bundle)
        }


    }

    inner class ViewHolder(val view: ImageItemLayoutBinding) :
        RecyclerView.ViewHolder(view.root) {

    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NasaModel>() {
            override fun areItemsTheSame(
                oldItem: NasaModel,
                newItem: NasaModel
            ): Boolean {
                return oldItem.nasaId == newItem.nasaId
            }

            override fun areContentsTheSame(
                oldItem: NasaModel,
                newItem: NasaModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
