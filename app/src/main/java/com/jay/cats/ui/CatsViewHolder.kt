package com.jay.cats.ui

import androidx.recyclerview.widget.RecyclerView
import com.jay.cats.BR
import com.jay.cats.databinding.ItemCatBinding
import com.jay.cats.model.Cat

class CatsViewHolder(
    private val binding: ItemCatBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Cat) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }

}