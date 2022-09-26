package com.example.movieapp.data.repository.tvshow

import com.example.movieapp.data.model.tvshow.TvShow
import com.example.movieapp.data.repository.tvshow.dataStorage.TvShowCacheDataStorage
import com.example.movieapp.data.repository.tvshow.dataStorage.TvShowLocalDataStorage
import com.example.movieapp.data.repository.tvshow.dataStorage.TvShowRemoteDataStorage
import com.example.movieapp.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataStorage: TvShowRemoteDataStorage,
    private val tvShowLocalDataStorage: TvShowLocalDataStorage,
    private val tvShowCacheDataStorage: TvShowCacheDataStorage

) : TvShowRepository{
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newestTvShows = getTvShowsFromAPI()
        tvShowLocalDataStorage.clearAllTvShows()
        tvShowLocalDataStorage.saveTvShowsToDB(newestTvShows)
        tvShowCacheDataStorage.saveTvShows(newestTvShows)
        return newestTvShows
    }

    private suspend fun getTvShowsFromAPI()  : List<TvShow>
    {
        lateinit var tvShowList : List<TvShow>

        try {
            val response = tvShowRemoteDataStorage.getTvShowsFromAPI()
            val body = response.body()
            if(body != null)
            {
                tvShowList = body.results
            }
        }
        catch (e : Exception) {
            e.printStackTrace()
        }
        return tvShowList
    }
    private suspend fun getTvShowsFromDB() : List<TvShow>
    {
        lateinit var tvShowList : List<TvShow>

        try {
            tvShowList = tvShowLocalDataStorage.getTvShowsFromDB()
        }
        catch (e : Exception) {
            e.printStackTrace()
        }
        if(tvShowList.isNotEmpty()) return tvShowList
        else
        {
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataStorage.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }
    private suspend fun getTvShowsFromCache() : List<TvShow>
    {
        lateinit var tvShowList : List<TvShow>

        try {
            tvShowList = tvShowCacheDataStorage.getTvShows()
        }
        catch (e  : Exception) {
            e.printStackTrace()
        }
        if(tvShowList.isNotEmpty()) return tvShowList
        else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataStorage.saveTvShows(tvShowList)
        }
        return tvShowList


    }
}