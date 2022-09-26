package com.example.movieapp.domain.repository

import com.example.movieapp.data.model.tvshow.TvShow

interface TvShowRepository {

    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?
}