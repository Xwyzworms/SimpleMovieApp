package com.example.movieapp.data.repository.artist.dataStorage

import com.example.movieapp.data.model.artist.Artist

interface ArtistCacheDataStorage {

    suspend fun getArtists() : List<Artist>
    suspend fun saveArtists(artists : List<Artist>)


}