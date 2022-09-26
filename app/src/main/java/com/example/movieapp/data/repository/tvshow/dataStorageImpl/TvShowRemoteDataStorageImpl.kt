package com.example.movieapp.data.repository.tvshow.dataStorageImpl

import com.example.movieapp.data.api.TMBDService
import com.example.movieapp.data.model.tvshow.TvShow
import com.example.movieapp.data.model.tvshow.TvShowList
import com.example.movieapp.data.repository.tvshow.dataStorage.TvShowRemoteDataStorage
import retrofit2.Response

class TvShowRemoteDataStorageImpl(private val tmbdService: TMBDService, private val apiKey : String ) : TvShowRemoteDataStorage {
    override suspend fun getTvShowsFromAPI(): Response<TvShowList> {
        return tmbdService.getPopularTvShows(apiKey)
    }
}