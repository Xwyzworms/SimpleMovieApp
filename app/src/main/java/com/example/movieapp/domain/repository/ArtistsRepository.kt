package com.example.movieapp.domain.repository

import com.example.movieapp.data.model.artist.Artist

interface ArtistsRepository {
    suspend fun getArtist() : List<Artist>?
    suspend fun updateArtist() : List<Artist>?
}