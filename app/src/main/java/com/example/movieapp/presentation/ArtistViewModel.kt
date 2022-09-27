package com.example.movieapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieapp.data.model.artist.Artist
import com.example.movieapp.domain.usecase.GetArtistsUseCase
import com.example.movieapp.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase : GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
    ) : ViewModel() {

    fun getArtists(): LiveData<List<Artist>?> = liveData {
        val artists = getArtistsUseCase.execute()
        emit(artists)
    }

    fun updateArtists() : LiveData<List<Artist>?> = liveData{
        val updatedArtists = updateArtistsUseCase.execute()
        emit(updatedArtists)
    }
}

