package com.example.movieapp.data.repository.tvshow.dataStorageImpl

import androidx.room.Dao
import com.example.movieapp.data.db.TVshowDAO
import com.example.movieapp.data.model.tvshow.TvShow
import com.example.movieapp.data.repository.tvshow.dataStorage.TvShowLocalDataStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataStorageImpl(private val tvShowDao: TVshowDAO) : TvShowLocalDataStorage{
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAllTvShows()
    {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }


}