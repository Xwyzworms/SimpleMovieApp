package com.example.movieapp.data.repository.movie.dataStorage

import com.example.movieapp.data.model.movie.Movie

interface MovieCacheDataStorage {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)
}