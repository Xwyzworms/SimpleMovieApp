package com.example.movieapp.data.api.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.api.model.artist.Artist
import com.example.movieapp.data.api.model.movie.Movie
import com.example.movieapp.data.api.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version= 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDAO
    abstract fun tvDao() : TVshowDAO
    abstract fun artistDao() : ArtistDAO

}