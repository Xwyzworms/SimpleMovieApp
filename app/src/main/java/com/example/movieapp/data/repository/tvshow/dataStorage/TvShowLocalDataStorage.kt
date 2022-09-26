package com.example.movieapp.data.repository.tvshow.dataStorage

import com.example.movieapp.data.model.tvshow.TvShow

interface TvShowLocalDataStorage {
    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShows : List<TvShow>)
    suspend fun clearAllTvShows()
}