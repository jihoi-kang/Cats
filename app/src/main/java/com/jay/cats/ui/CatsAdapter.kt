package com.jay.cats.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.jay.cats.R
import com.jay.cats.databinding.ItemCatBinding
import com.jay.cats.model.Cat

class CatsAdapter : PagingDataAdapter<Cat, CatsViewHolder>(REPO_COMPARATOR) {

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.bind(getItem(position) ?: return)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val binding = DataBindingUtil.inflate<ItemCatBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_cat,
            parent,
            false
        )
        return CatsViewHolder(binding)
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<Cat>() {
            override fun areItemsTheSame(oldItem: Cat, newItem: Cat) =
                oldItem.imageUrl == newItem.imageUrl

            override fun areContentsTheSame(oldItem: Cat, newItem: Cat) =
                oldItem.imageUrl == newItem.imageUrl
        }
    }

}