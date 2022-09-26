package com.example.movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.model.tvshow.TvShow


@Dao
interface TVshowDAO {

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShows();

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows() : List<TvShow>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShows: List<TvShow>)
}