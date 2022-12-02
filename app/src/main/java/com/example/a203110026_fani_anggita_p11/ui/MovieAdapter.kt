package com.example.a203110026_fani_anggita_p11.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a203110026_fani_anggita_p11.data.Movie
import com.example.a203110026_fani_anggita_p11.databinding.AdapterMovieBinding
import javax.inject.Inject

// TODO 3: Class Adapter
class MovieAdapter @Inject constructor() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // variabel untuk menerima mutable list movie
    var movies = mutableListOf<Movie>()
    private var clickInterface: ClickInterface<Movie>? = null

    // fungsi ini akan mengembalikan mutable list movie
    fun updateMovies(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyItemRangeInserted(0, movies.size)
    }


    // TODO 9: Bagian untuk menampilkan gambar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.view.tvTitle.text = movie.title
        holder.view.rvYear.text = "Year : ${movie.year}"
        holder.view.rvRating.text = "Rating : ${movie.imDbRating}"
        Glide
            .with(holder.view.imgMovieImage.context)
            .load(movie.image)
            .centerCrop()
            .into(holder.view.imgMovieImage)
        holder.view.movieCard.setOnClickListener {
            clickInterface?.onClick(movie)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun setItemClick(clickInterface: ClickInterface<Movie>) {
        this.clickInterface = clickInterface
    }

    class MovieViewHolder(val view: AdapterMovieBinding) : RecyclerView.ViewHolder(view.root)
}

interface ClickInterface<T> {
    fun onClick(data: T)
}