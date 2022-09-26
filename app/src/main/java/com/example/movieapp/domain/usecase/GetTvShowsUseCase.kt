package com.example.movieapp.domain.usecase

import com.example.movieapp.domain.repository.TvShowRepository
import com.example.movieapp.data.model.tvshow.TvShow

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute() : List<TvShow>? = tvShowRepository.getTvShows()
}