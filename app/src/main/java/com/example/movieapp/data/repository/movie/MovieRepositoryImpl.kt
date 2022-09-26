package com.example.movieapp.data.repository.movie

import com.example.movieapp.data.model.movie.Movie
import com.example.movieapp.data.repository.movie.dataStorage.MovieCacheDataStorage
import com.example.movieapp.data.repository.movie.dataStorage.MovieLocalDataStorage
import com.example.movieapp.data.repository.movie.dataStorage.MovieRemoteDataStorage
import com.example.movieapp.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDataStorage: MovieRemoteDataStorage,
    private val movieLocalDataStorage: MovieLocalDataStorage,
    private val movieCacheDataStorage: MovieCacheDataStorage

) : MovieRepository{
    override suspend fun getMovies(): List<Movie>? {
        //Check Cache
        // If not exists
        // Get From Db First

        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataStorage.clearAll()
        movieLocalDataStorage.saveMoviesToDB(newListOfMovies)
        movieCacheDataStorage.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI() : List<Movie>
    {
        lateinit var movieList : List<Movie>
        try{
            val response = movieRemoteDataStorage.getMovies()
            val body = response.body()
            if( body != null )
            {
                movieList = body.results
                //movieLocalDataStorage.saveMoviesToDB(movieList)
            }
        }catch (e : Exception)
        {
            e.printStackTrace()
        }
        return movieList
    }

    private suspend fun getMoviesFromDB() : List<Movie>
    {
        lateinit var movieList : List<Movie>
        try
        {
             movieList = movieLocalDataStorage.getMoviesFromDB()

        }
        catch (e : Exception)
        {
            e.printStackTrace()
        }

        if(movieList.isNotEmpty())
        return movieList
        else
        {
            movieList = getMoviesFromAPI()
            movieLocalDataStorage.saveMoviesToDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache() : List<Movie>
    {
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDataStorage.getMoviesFromCache()
        }
        catch (e : Exception)
        {
            e.printStackTrace()
        }

        if(movieList.isNotEmpty()) return movieList
        else
        {
            movieList = getMoviesFromDB()
            movieCacheDataStorage.saveMoviesToCache(movieList)
        }
        return movieList

    }
}