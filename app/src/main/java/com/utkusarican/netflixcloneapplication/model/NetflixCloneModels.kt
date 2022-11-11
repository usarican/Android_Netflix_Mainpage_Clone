package com.utkusarican.netflixcloneapplication.model

import androidx.recyclerview.widget.RecyclerView

data class BannerMovieModels(
    val id : Int,
    val name : String,
    val gender : String,
    val imageUrl : String
)
data class AllCategory(
    val category : String,
    val categoryItemList : List<CategoryItemModel>

)
data class CategoryItemModel(
    val itemId : Int,
    val imageUrl : Int
)
