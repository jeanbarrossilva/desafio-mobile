package com.jeanbarrossilva.ingresso.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.jeanbarrossilva.ingresso.model.Movie
import com.jeanbarrossilva.ingresso.ui.core.IngressoFragment
import com.jeanbarrossilva.ingresso.ui.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment: IngressoFragment<FragmentMovieDetailsBinding>() {
    private val movie
        get() = requireArguments().getParcelable<Movie>(EXTRA_MOVIE)!!

    override val bindingClass = FragmentMovieDetailsBinding::class

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.originalTitleView.description = movie.title.original
        binding.castView
            .apply { description = movie.cast.joinToString() }
            .also { it.isVisible = movie.cast.isNotEmpty() }
        binding.synopsisView
            .apply { description = movie.synopsis.orEmpty() }
            .also { it.isVisible = movie.synopsis != null }
        binding.directorView
            .apply { description = movie.director.orEmpty() }
            .also { it.isVisible = movie.director != null }
        binding.distributorView
            .apply { description = movie.distributor.orEmpty() }
            .also { it.isVisible = movie.distributor != null }
        binding.countryView
            .apply { description = movie.country.orEmpty() }
            .also { it.isVisible = movie.country != null }
    }

    companion object {
        const val EXTRA_MOVIE = "movie"
    }
}