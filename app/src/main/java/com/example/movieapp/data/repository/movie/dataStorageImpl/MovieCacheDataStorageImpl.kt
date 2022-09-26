package com.example.movieapp.data.repository.movie.dataStorageImpl

import com.example.movieapp.data.model.movie.Movie
import com.example.movieapp.data.repository.movie.dataStorage.MovieCacheDataStorage

class MovieCacheDataStorageImpl : MovieCacheDataStorage {
    private var moviesList : ArrayList<Movie> = ArrayList()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        moviesList.clear()
        moviesList = ArrayList(movies)
    }
}