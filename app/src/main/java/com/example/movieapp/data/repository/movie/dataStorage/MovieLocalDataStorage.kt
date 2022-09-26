package com.example.movieapp.data.repository.movie.dataStorage

import com.example.movieapp.data.model.movie.Movie

interface MovieLocalDataStorage {
    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()
}