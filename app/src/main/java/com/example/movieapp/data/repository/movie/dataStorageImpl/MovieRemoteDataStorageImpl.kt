package com.example.movieapp.data.repository.movie.dataStorageImpl

import com.example.movieapp.data.api.TMBDService
import com.example.movieapp.data.model.movie.MovieList
import com.example.movieapp.data.repository.movie.dataStorage.MovieRemoteDataStorage
import retrofit2.Response

class MovieRemoteDataStorageImpl(private val tmbdService: TMBDService, private val apiKey : String) :
    MovieRemoteDataStorage {
    override suspend fun getMovies(): Response<MovieList> {
        return tmbdService.getPopularMovies(apiKey)
    }
}