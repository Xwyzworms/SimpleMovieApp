package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.repository.MovieRepository
import com.example.movieapp.data.model.movie.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun execute() : List<Movie>? = movieRepository.getMovies()
}