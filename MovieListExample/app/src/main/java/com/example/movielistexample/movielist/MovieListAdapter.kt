package com.example.movielistexample.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.movielistexample.databinding.MovieItemBinding
import com.example.movielistexample.models.Movie

class MovieListAdapter: ListAdapter<Movie, MovieViewHolder>(DiffUtilCallback()) {
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
        val item = getItem(position)   // data.getOrNull БЫЛО В ПРОШЛОМ АДАПТОРЕ
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
class DiffUtilCallback: DiffUtil.ItemCallback<Movie>(){
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean
        = oldItem.kinipoiskId == newItem.kinipoiskId

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem

}