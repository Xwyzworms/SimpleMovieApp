package com.example.movieapp.data.repository.movie.dataStorage

import com.example.movieapp.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataStorage {

    suspend fun getMovies() : Response<MovieList>

}