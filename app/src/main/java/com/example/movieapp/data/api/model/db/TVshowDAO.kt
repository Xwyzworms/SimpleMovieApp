package com.example.movieapp.data.api.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.api.model.artist.Artist
import com.example.movieapp.data.api.model.tvshow.TvShow


@Dao
interface TVshowDAO {

    @Query("DELETE FROM popular_tvshows")
    suspend fun deleteAllTvShows();

    @Query("SELECT * FROM popular_tvshows")
    suspend fun getTvShows()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShow: TvShow)
}