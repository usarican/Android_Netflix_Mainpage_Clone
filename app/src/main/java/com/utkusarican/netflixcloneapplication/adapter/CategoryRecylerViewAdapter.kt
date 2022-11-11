package com.utkusarican.netflixcloneapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.utkusarican.netflixcloneapplication.databinding.ChildRecyclerviewItemBinding
import com.utkusarican.netflixcloneapplication.model.CategoryItemModel

class CategoryRecylerViewAdapter : ListAdapter<CategoryItemModel,CategoryRecylerViewAdapter.CategoryItemViewHolder>(
    COMPARATOR_CATEGORYITEM) {

    class CategoryItemViewHolder(private val binding: ChildRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(categoryItem : CategoryItemModel){
            binding.apply {
                categoryItemImage.setImageResource(categoryItem.imageUrl)
            }
        }
    }

    companion object {
        val COMPARATOR_CATEGORYITEM = object : DiffUtil.ItemCallback<CategoryItemModel>(){
            override fun areItemsTheSame(
                oldItem: CategoryItemModel,
                newItem: CategoryItemModel
            ): Boolean {
                return oldItem.itemId == newItem.itemId
            }

            override fun areContentsTheSame(
                oldItem: CategoryItemModel,
                newItem: CategoryItemModel
            ): Boolean {
                return oldItem.itemId == newItem.itemId
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        val binding = ChildRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        val currentItem = getItem(position)
        currentItem?.let {
            holder.bind(it)
        }
    }
}