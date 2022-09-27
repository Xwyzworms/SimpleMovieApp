package com.example.movieapp.data.repository.artist.dataStorageImpl

import com.example.movieapp.data.model.artist.Artist
import com.example.movieapp.data.repository.artist.dataStorage.ArtistCacheDataStorage

class ArtistCacheDataStorageImpl : ArtistCacheDataStorage {
    private var artistTemp = ArrayList<Artist>()
    override suspend fun getArtists(): List<Artist> {
        return artistTemp
    }

    override suspend fun saveArtists(artists: List<Artist>) {
        artistTemp.clear()
        artistTemp = ArrayList(artists)
    }

}