package com.example.movieapp.data.repository.tvshow.dataStorage

import com.example.movieapp.data.model.tvshow.TvShow
import com.example.movieapp.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataStorage {

    suspend fun getTvShowsFromAPI () : Response<TvShowList>
}