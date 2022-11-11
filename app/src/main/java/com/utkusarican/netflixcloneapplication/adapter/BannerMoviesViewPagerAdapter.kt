package com.utkusarican.netflixcloneapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.utkusarican.netflixcloneapplication.databinding.BannerMoviesLayoutBinding
import com.utkusarican.netflixcloneapplication.model.BannerMovieModels

class BannerMoviesViewPagerAdapter(private val bannerMovies : List<BannerMovieModels>) : RecyclerView.Adapter<BannerMoviesViewPagerAdapter.BannerMoviesViewHolder>() {

    class BannerMoviesViewHolder(private val binding: BannerMoviesLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(bannerMovie : BannerMovieModels){
            binding.apply {
                bannerMovieImage.setImageResource(bannerMovie.imageUrl)
                bannerMovieName.text = bannerMovie.name
                bannerMovieGender.text = bannerMovie.gender
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerMoviesViewHolder {
        val binding = BannerMoviesLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BannerMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerMoviesViewHolder, position: Int) {
       holder.bind(
           bannerMovie = bannerMovies[position]
       )
    }

    override fun getItemCount() = bannerMovies.size
}