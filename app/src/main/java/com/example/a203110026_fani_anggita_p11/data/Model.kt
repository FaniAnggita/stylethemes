package com.example.a203110026_fani_anggita_p11.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
// TODO 5: Class Data
data class Movie (
    // set member class beserta tipe datanya
    @PrimaryKey
    val id: String,
    val title: String,
    val year: String,
    val image: String,
    val imDbRating: String
)

data class MovieResponse(val items: List<Movie>, val errorMessage: String)

sealed class NetworkResult<T> {
    data class Loading<T>(val isLoading: Boolean) : NetworkResult<T>()
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Failure<T>(val errorMessage: String) : NetworkResult<T>()
}

