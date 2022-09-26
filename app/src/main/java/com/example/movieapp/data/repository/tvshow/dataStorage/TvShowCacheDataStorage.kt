package com.example.movieapp.data.repository.tvshow.dataStorage

import com.example.movieapp.data.model.tvshow.TvShow

interface TvShowCacheDataStorage {
    suspend fun saveTvShows(tvShows : List<TvShow>)
    suspend fun getTvShows() : List<TvShow>
}