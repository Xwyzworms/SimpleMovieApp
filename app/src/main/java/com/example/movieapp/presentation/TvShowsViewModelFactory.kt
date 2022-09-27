package com.example.movieapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movieapp.domain.usecase.GetTvShowsUseCase
import com.example.movieapp.domain.usecase.UpdateTvShowsUseCase


class TvShowsViewModelFactory(
    private val getTvShowsUseCase : GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowsUseCase, updateTvShowsUseCase) as T
    }
}