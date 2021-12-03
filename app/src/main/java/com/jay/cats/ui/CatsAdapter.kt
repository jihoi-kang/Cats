package com.jay.cats.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jay.cats.R
import com.jay.cats.databinding.ItemCatBinding
import com.jay.cats.model.Cat

class CatsAdapter : RecyclerView.Adapter<CatsViewHolder>() {

    private val items = mutableListOf<Cat>()

    fun updateItems(items: List<Cat>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val binding = DataBindingUtil.inflate<ItemCatBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_cat,
            parent,
            false
        )

        return CatsViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

}