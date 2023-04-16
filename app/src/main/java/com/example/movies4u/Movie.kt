package com.example.movies4u


data class Movie(

     val id: Int,
     val title: String,
     val imageUrl: String,
     val certification: String,
     val actors: String,
     val description: String,
     val runningTime: String,
     val seatsRemaining1: String,
     var seatsSelected: Int,
     var seatsRemaining: Int

     )

