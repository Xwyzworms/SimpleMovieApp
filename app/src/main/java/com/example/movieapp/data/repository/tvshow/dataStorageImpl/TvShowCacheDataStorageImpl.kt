package com.example.movieapp.data.repository.tvshow.dataStorageImpl

import com.example.movieapp.data.model.tvshow.TvShow
import com.example.movieapp.data.repository.tvshow.dataStorage.TvShowCacheDataStorage

class TvShowCacheDataStorageImpl : TvShowCacheDataStorage{
    var arrayTvShow : ArrayList<TvShow> = ArrayList()
    override suspend fun saveTvShows(tvShows: List<TvShow>) {
        arrayTvShow.clear()
        arrayTvShow = ArrayList(tvShows)
    }

    override suspend fun getTvShows(): List<TvShow> {
        return arrayTvShow
    }
}