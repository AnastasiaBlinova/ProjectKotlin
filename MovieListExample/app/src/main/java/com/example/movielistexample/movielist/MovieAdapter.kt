package com.example.movielistexample.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movielistexample.databinding.MovieItemBinding
import com.example.movielistexample.models.Movie

class MovieAdapter : RecyclerView.Adapter<MovieViewHolder>() {
    private var data: List<Movie> = emptyList()

    fun setData(date: List<Movie>){
        this.data = data
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data.getOrNull(position)
        with(holder.binding){
            title.text = item?.nameRu ?: ""
            genres.text = item?.genres?.joinToString(", "){it.genre}
            description.text = "Премьера ${item?.premierRu}"
            countries.text = item?.countries?.joinToString(", "){it.country}
            item?.let {
                Glide
                    .with(poster.context)
                    .load(it.posterUriPreView)
                    .into(poster)
            }
        }
    }
}
 class MovieViewHolder(val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root)


























