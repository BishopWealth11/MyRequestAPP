package com.bishop.requestingapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bishop.requestingapp.databinding.ItemListBinding
import com.bishop.requestingapp.models.Item

class ItemAdapter(var items: List<Item>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun dataset(item: Item) {
            binding.apply {
                tvId.text = item.id.toString()
                tvName.text = item.name
                tvPrice.text = item.price.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding: ItemListBinding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.dataset(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}