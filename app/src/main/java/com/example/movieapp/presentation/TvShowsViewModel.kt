package com.example.movieapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.data.model.movie.Movie
import com.example.movieapp.data.model.tvshow.TvShow
import com.example.movieapp.domain.usecase.GetTvShowsUseCase
import com.example.movieapp.domain.usecase.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase : UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows () : LiveData<List<TvShow>?>   = liveData{
        val tvShowList = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows() : LiveData<List<TvShow>?> = liveData {
        val updated = updateTvShowsUseCase.execute()
        emit(updated)
    }

}