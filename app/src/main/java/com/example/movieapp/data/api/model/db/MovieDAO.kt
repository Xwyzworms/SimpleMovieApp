package com.example.movieapp.data.api.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.api.model.artist.Artist
import com.example.movieapp.data.api.model.movie.Movie

@Dao
interface MovieDAO {

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies();

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movie : Movie)

}