package com.example.movieapp.data.repository.artist.dataStorageImpl

import com.example.movieapp.data.api.TMBDService
import com.example.movieapp.data.model.artist.ArtistList
import com.example.movieapp.data.repository.artist.dataStorage.ArtistRemoteDataStorage
import retrofit2.Response

class ArtistRemoteDataStorageImpl(private val tmbdService: TMBDService, private val apiKey: String ) : ArtistRemoteDataStorage{
    override suspend fun getArtists(): Response<ArtistList> {
        return tmbdService.getPopularArtists(apiKey )
    }
}