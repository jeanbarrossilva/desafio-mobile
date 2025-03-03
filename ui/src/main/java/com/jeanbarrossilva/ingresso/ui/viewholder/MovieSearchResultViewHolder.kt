package com.jeanbarrossilva.ingresso.ui.viewholder

import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.jeanbarrossilva.ingresso.model.Movie
import com.jeanbarrossilva.ingresso.ui.R
import com.jeanbarrossilva.ingresso.ui.databinding.ViewMovieSearchResultBinding
import com.jeanbarrossilva.ingresso.ui.extensions.imageview.loadPortraitOf

class MovieSearchResultViewHolder(private val binding: ViewMovieSearchResultBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie, onClick: (Movie) -> Unit) {
        binding.root.children.first().setOnClickListener { onClick(movie) }
        binding.imagePortraitView.loadPortraitOf(movie.imageUrl)
        binding.imagePortraitView.contentDescription =
            binding.root.context.getString(R.string.movie_image_content_description, movie.title.localized)
        binding.titleView.text = movie.title.localized
        binding.genreView.text = movie.genres.joinToString()
    }
}