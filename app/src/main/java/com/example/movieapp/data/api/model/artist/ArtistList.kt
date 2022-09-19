package com.example.movieapp.data

import com.example.movieapp.data.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val artists: List<Artist>,

    )