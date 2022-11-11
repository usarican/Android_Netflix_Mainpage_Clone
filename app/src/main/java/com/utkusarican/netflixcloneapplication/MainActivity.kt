package com.utkusarican.netflixcloneapplication

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utkusarican.netflixcloneapplication.adapter.BannerMoviesViewPagerAdapter
import com.utkusarican.netflixcloneapplication.adapter.MainRecyclerViewAdapter
import com.utkusarican.netflixcloneapplication.databinding.ActivityMainBinding
import com.utkusarican.netflixcloneapplication.model.AllCategory
import com.utkusarican.netflixcloneapplication.model.BannerMovieModels
import com.utkusarican.netflixcloneapplication.model.CategoryItemModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val mainRecyclerViewAdapter = MainRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN



        setupAllCategory()

    }

    private fun setupAllCategory(){

        val movieBannerList : MutableList<BannerMovieModels> = arrayListOf()
        movieBannerList.add(BannerMovieModels(0,"WARRIOR NUN","Drama ● Superhero ● Teen",R.drawable.banner_movie1))
        movieBannerList.add(BannerMovieModels(0,"THRILLER","Thriller ● Horror ",R.drawable.banner_movie2))
        movieBannerList.add(BannerMovieModels(0,"THE WITCHER","Advanture ● Fantasy ● Drama",R.drawable.banner_movie3))
        movieBannerList.add(BannerMovieModels(0,"IO LAST ON EARTH","Science Fiction ● Horror ● Action",R.drawable.movie1))
        movieBannerList.add(BannerMovieModels(0,"DAREDEVIL","Crime ● Superhero ● Action",R.drawable.banner_movie5))

        val bannerMovieViewPagerAdapter = BannerMoviesViewPagerAdapter(movieBannerList)

        val oONCategoryList : MutableList<CategoryItemModel> = arrayListOf()
        oONCategoryList.add(CategoryItemModel(0,R.drawable.movie1))
        oONCategoryList.add(CategoryItemModel(1,R.drawable.movie2))
        oONCategoryList.add(CategoryItemModel(2,R.drawable.movie3))
        oONCategoryList.add(CategoryItemModel(3,R.drawable.movie4))
        oONCategoryList.add(CategoryItemModel(4,R.drawable.movie5))

        val tNCategoryList : MutableList<CategoryItemModel> = arrayListOf()
        tNCategoryList.add(CategoryItemModel(5,R.drawable.movie6))
        tNCategoryList.add(CategoryItemModel(6,R.drawable.movie7))
        tNCategoryList.add(CategoryItemModel(7,R.drawable.movie8))
        tNCategoryList.add(CategoryItemModel(8,R.drawable.movie9))
        tNCategoryList.add(CategoryItemModel(9,R.drawable.movie10))

        val rACategoryList : MutableList<CategoryItemModel> = arrayListOf()
        rACategoryList.add(CategoryItemModel(10,R.drawable.movie11))
        rACategoryList.add(CategoryItemModel(11,R.drawable.movie12))
        rACategoryList.add(CategoryItemModel(12,R.drawable.movie13))
        rACategoryList.add(CategoryItemModel(13,R.drawable.movie14))
        rACategoryList.add(CategoryItemModel(14,R.drawable.movie15))


        val allCategoryList : MutableList<AllCategory> = arrayListOf()
        allCategoryList.add(AllCategory("Only On Netflix",oONCategoryList))
        allCategoryList.add(AllCategory("Trending Now",tNCategoryList))
        allCategoryList.add(AllCategory("Recently Added",rACategoryList))


        binding.apply {
            homepageMovielistsRecyclerview.adapter = mainRecyclerViewAdapter
            homepageMovielistsRecyclerview.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
            homepageMovielistsRecyclerview.setHasFixedSize(true)
            bannerMoviePager.adapter = bannerMovieViewPagerAdapter
        }
        mainRecyclerViewAdapter.submitList(allCategoryList)

    }


}