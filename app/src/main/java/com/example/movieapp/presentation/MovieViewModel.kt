package com.example.movieapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.data.model.movie.Movie
import com.example.movieapp.domain.usecase.GetMoviesUseCase
import com.example.movieapp.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getmoviesUseCase : GetMoviesUseCase,
    private val updateMoviesUseCase : UpdateMoviesUseCase

) : ViewModel() {

    fun getMovies() : LiveData<List<Movie>?> = liveData {
        val movies = getmoviesUseCase.execute()
        emit(movies)
    }

    fun updateMovies () : LiveData<List<Movie>?> = liveData {
        val updatedMovies = updateMoviesUseCase.execute()
        emit(updatedMovies)
    }
}