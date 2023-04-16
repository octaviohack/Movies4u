package com.example.movies4u

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movies4u.databinding.ActivityMainBinding
import kotlin.random.Random

private val Number.seatsRemaining: Int
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding
    val movies = listOf(
        Movie(
            1,
            "CREED III",
            "https://www.myvue.com/-/media/8000b40d5bfd4148b1c2195fdd490a11.png/w780",
            "TBC",
            "Michael B. Jordan, Tessa Thompson, Jonathan Majors, Wood Harris",
            "When a childhood friend and former boxing prodigy, Damian (Jonathan Majors), resurfaces after serving a long sentence in prison, he is eager to prove that he deserves his shot in the ring.",
            "1hr 56mins",
            "",
            0,
            0
        ),
        Movie(
            2,
            "GUARDIANS OF THE GALAXY",
            "https://m.media-amazon.com/images/I/81NcnbKcqOL._AC_SX679_.jpg",
            "PG-13",
            "Dave Bautista, Chris Pratt, Zoe Saldana, Vin Diesel, Karen Gillan, Bradley Cooper",
            "Peter Quill, still reeling from the loss of Gamora, must rally his team around him to defend the universe along with protecting one of their own.",
            "2hr 23mins",
            "",
            0,
            0
        ),
        Movie(
            3,
            "THE SUPER MARIO BROS",
            "https://nintendoeverything.com/wp-content/uploads/Mario-movie-poster-2.jpg",
            "PG",
            "Chris Pratt, Anya Taylor-Joy, Charlie Day, Jack Black, Seth Rogen",
            "A plumber named Mario travels through an underground labyrinth with his brother, Luigi, trying to save a captured princess.",
            "1hr 32mins",
            "",
            0,
            0
        ),
        Movie(
            4,
            "65",
            "https://www.myvue.com/-/media/27431c240ce34e438007f591b85d194e.png?/w780",
            "PG-13",
            "Adam Driver, Ariana Greenblatt",
            "After a catastrophic crash on an unknown planet, pilot Mills (Adam Driver) quickly discovers he's actually stranded on Earth... 65 million years ago.",
            "1hr 33mins",
            "14",
            0,
            0
        ),
        Movie(
            5,
            "SUZUME",
            "https://www.myvue.com/-/media/ac12cc48f2a64278ae7151ab0c861f90.png?/w780",
            "PG",
            "Eri Fukatsu, Hokuto Matsumura, Nanoka Hara",
            "On the other side of the door, was time in its entirety. As the skies turn red and the earth trembles, Japan stands on the brink of disaster. Suzume, sets out on a mission to save her country.",
            "2hr 2mins",
            "",
            0,
            0
        ),
        Movie(
            6,
            "EVIL DEAD RISE",
            "https://www.myvue.com/-/media/757c322eb6a944de8be9aa9c0a9455b1.png?/w780",
            "18",
            "Gabrielle Echols, Lily Sullivan, Alyssa Sutherland",
            "Moving the action out of the woods and into the city, Evil Dead Rise follows a group of friends who unwittingly summon an evil force that turns them against one another.",
            "1hr 30mins",
            "",
            0,
            0 )
    )


                    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = MovieAdapter(movies)

        // Update the seats remaining for each movie
        movies.forEach { movie ->
            movie.seatsRemaining = Random.nextInt(0, 16)
        }

        checkSeatAvailability()
    }

    private fun checkSeatAvailability() {
        for (i in 0 until binding.recycler.childCount) {
            val itemView = binding.recycler.getChildAt(i)
            val movie = (binding.recycler.adapter as MovieAdapter).getItemId(i)
            val fillingFastBadge = itemView.findViewById<TextView>(R.id.movie_badge)
            if (movie.seatsRemaining in 1..2) {
                fillingFastBadge.visibility = View.VISIBLE
            } else {
                fillingFastBadge.visibility = View.GONE
            }
        }
    }

    }

