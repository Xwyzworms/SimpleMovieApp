package com.example.movieapp.data.repository.artist

import com.example.movieapp.data.model.artist.Artist
import com.example.movieapp.data.repository.artist.dataStorage.ArtistCacheDataStorage
import com.example.movieapp.data.repository.artist.dataStorage.ArtistLocalDataStorage
import com.example.movieapp.data.repository.artist.dataStorage.ArtistRemoteDataStorage
import com.example.movieapp.domain.repository.ArtistsRepository

class ArtistRepositoryImpl(private val artistRemoteDataStorage: ArtistRemoteDataStorage,
                           private val artistLocalDataStorage : ArtistLocalDataStorage,
                           private val artistCacheDataStorage : ArtistCacheDataStorage ) : ArtistsRepository
{
    override suspend fun getArtist(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newUpdatedArtists = getArtistsFromAPI()
        artistLocalDataStorage.clearAll()
        artistLocalDataStorage.saveArtistsToLocalDB(newUpdatedArtists)
        artistCacheDataStorage.saveArtists(newUpdatedArtists)
        return newUpdatedArtists
    }

    suspend fun getArtistsFromAPI() : List<Artist>
    {
        lateinit var tempArtists : List<Artist>
        try {
            val response = artistRemoteDataStorage.getArtists()
            val body = response.body()
            if(body != null)
            {
                tempArtists = body.artists
            }
        }catch (e : Exception)
        {
            e.printStackTrace()
        }

        return tempArtists
    }

    suspend fun getArtistsFromDB() : List<Artist>
    {
        lateinit var tempArtists : List<Artist>
        try {
            tempArtists = artistLocalDataStorage.getArtistsFromLocalDB()

        }catch (e : Exception)
        {
            e.printStackTrace()
        }

        if(tempArtists.isNotEmpty()) return tempArtists
        else
        {
            tempArtists = getArtistsFromAPI()
            artistLocalDataStorage.saveArtistsToLocalDB(tempArtists)
            return tempArtists
        }
    }


    suspend fun getArtistsFromCache() : List<Artist>
    {
        lateinit var tempArtist : List<Artist>
        try
        {
            tempArtist = artistCacheDataStorage.getArtists()

        }catch (e : Exception)
        {
            e.printStackTrace()
        }

        if(tempArtist.isNotEmpty()) return tempArtist

        else
        {
            tempArtist = getArtistsFromDB()
            artistCacheDataStorage.saveArtists(tempArtist)
        }

        return tempArtist
    }
}