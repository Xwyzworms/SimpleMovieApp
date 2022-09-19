package com.example.movieapp.data.api.model.api

import com.example.movieapp.data.api.model.artist.ArtistList
import com.example.movieapp.data.api.model.movie.MovieList
import com.example.movieapp.data.api.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMBDService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apiKey : String) : Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apiKey : String) : Response<ArtistList>

}