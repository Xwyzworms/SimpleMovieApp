package com.example.movieapp.data.repository.artist.dataStorageImpl

import com.example.movieapp.data.db.ArtistDAO
import com.example.movieapp.data.model.artist.Artist
import com.example.movieapp.data.repository.artist.dataStorage.ArtistLocalDataStorage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataStorageImpl(private val artistDAO: ArtistDAO) : ArtistLocalDataStorage{
    override suspend fun saveArtistsToLocalDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDAO.saveArtists(artists)
        }
    }

    override suspend fun getArtistsFromLocalDB(): List<Artist> {
        return artistDAO.getArtist()
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch{
            artistDAO.deleteAllArtists()
        }
    }
}