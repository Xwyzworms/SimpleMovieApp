package com.example.movieapp.data.repository.artist.dataStorage

import com.example.movieapp.data.model.artist.Artist

interface ArtistLocalDataStorage {

    suspend fun saveArtistsToLocalDB(artists : List<Artist>)
    suspend fun getArtistsFromLocalDB() : List<Artist>
    suspend fun clearAll()


}