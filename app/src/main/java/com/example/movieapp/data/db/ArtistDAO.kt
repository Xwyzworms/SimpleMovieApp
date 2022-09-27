package com.example.movieapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieapp.data.model.artist.Artist

@Dao
interface ArtistDAO {

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtists();

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtist() : List<Artist>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtists(artists: List<Artist>)

}