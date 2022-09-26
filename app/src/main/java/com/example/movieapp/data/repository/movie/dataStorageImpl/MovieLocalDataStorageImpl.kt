package com.example.movieapp.data.repository.movie.dataStorageImpl

import com.example.movieapp.data.db.MovieDAO
import com.example.movieapp.data.model.movie.Movie
import com.example.movieapp.data.repository.movie.dataStorage.MovieLocalDataStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataStorageImpl(private val movieDAO: MovieDAO) : MovieLocalDataStorage {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDAO.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.saveMovies(movies)
        }

    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDAO.deleteAllMovies()
        }
    }
}