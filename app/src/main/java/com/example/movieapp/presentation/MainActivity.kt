package com.example.movieapp.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var intentBwang : Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.artistsButton.setOnClickListener {
            intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.moviesButton.setOnClickListener {
            intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)

        }
        binding.tvShowsButton.setOnClickListener {
            intent = Intent(this, TvShowsActivity::class.java)
            startActivity(intent)
        }

    }
}