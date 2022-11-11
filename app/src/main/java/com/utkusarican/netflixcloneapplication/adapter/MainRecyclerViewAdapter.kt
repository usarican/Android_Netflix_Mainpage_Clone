package com.utkusarican.netflixcloneapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.utkusarican.netflixcloneapplication.databinding.ParentRecyclerviewItemBinding
import com.utkusarican.netflixcloneapplication.model.AllCategory
import com.utkusarican.netflixcloneapplication.utils.MarginItemDecoration

class MainRecyclerViewAdapter : ListAdapter<AllCategory,MainRecyclerViewAdapter.AllCategoryViewHolder>(COMPARATION_CATEGORY) {

    class AllCategoryViewHolder(private val binding: ParentRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(allCategory: AllCategory){
            binding.categoryName.text = allCategory.category
            val categoryRecylerViewAdapter = CategoryRecylerViewAdapter()
            binding.childRecyclerviewMovies.layoutManager = LinearLayoutManager(binding.root.context,LinearLayoutManager.HORIZONTAL,false)
            categoryRecylerViewAdapter.submitList(allCategory.categoryItemList)
            binding.childRecyclerviewMovies.adapter = categoryRecylerViewAdapter
            binding.childRecyclerviewMovies.addItemDecoration(
                MarginItemDecoration(10)
            )

        }
    }

    companion object {
        val COMPARATION_CATEGORY = object : DiffUtil.ItemCallback<AllCategory>(){
            override fun areItemsTheSame(oldItem: AllCategory, newItem: AllCategory): Boolean {
                return oldItem.category == newItem.category
            }

            override fun areContentsTheSame(oldItem: AllCategory, newItem: AllCategory): Boolean {
                return oldItem.category == newItem.category
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllCategoryViewHolder {
        val binding = ParentRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AllCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllCategoryViewHolder, position: Int) {
        val allCategory = getItem(position)
        Log.d("MainAdapter",allCategory.toString())
        allCategory?.let {
         holder.bind(it)
        }
    }
}