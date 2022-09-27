package com.example.movieapp.data.repository.artist.dataStorage

import com.example.movieapp.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataStorage {

    suspend fun getArtists() : Response<ArtistList>
}