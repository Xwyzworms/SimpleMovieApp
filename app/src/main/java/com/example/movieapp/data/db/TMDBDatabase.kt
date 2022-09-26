package com.example.movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.model.artist.Artist
import com.example.movieapp.data.model.movie.Movie
import com.example.movieapp.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version= 1, exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDAO
    abstract fun tvDao() : TVshowDAO
    abstract fun artistDao() : ArtistDAO

}