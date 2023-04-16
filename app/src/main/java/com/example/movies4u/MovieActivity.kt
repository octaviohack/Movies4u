package com.example.movies4u



import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.movies4u.databinding.ActivityMovieBinding

@Suppress("DEPRECATION", "KotlinConstantConditions", "CAST_NEVER_SUCCEEDS")
class MovieActivity : AppCompatActivity() {

    companion object {
        const val MOVIE_ID = "MovieActivity:movie_id"
    }

    @SuppressLint("StringFormatInvalid")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val movieId = intent.getIntExtra(MOVIE_ID, -1)


        val movie = Movie(
            1,
            "CREED III",
            "https://www.myvue.com/-/media/8000b40d5bfd4148b1c2195fdd490a11.png?/w780",
            "TBC",
            "Michael B. Jordan, Tessa Thompson, Jonathan Majors, Wood Harris",
            "When a childhood friend and former boxing prodigy, Damian (Jonathan Majors), resurfaces after serving a long sentence in prison, he is eager to prove that he deserves his shot in the ring.",
            "1hr 56mins",
            "",
            0,
            7
        )
        Movie(
            2,
            "GUARDIANS OF THE GALAXY VOL.3",
            "https://m.media-amazon.com/images/I/81NcnbKcqOL._AC_SX679_.jpg",
            "PG-13",
            "Dave Bautista, Chris Pratt, Zoe Saldana, Vin Diesel, Karen Gillan, Bradley Cooper",
            "Peter Quill, still reeling from the loss of Gamora, must rally his team around him to defend the universe along with protecting one of their own.",
            "2hr 23mins",
            "",
            4,
            9
        )
        Movie(
            3,
            "THE SUPER MARIO BROS",
            "https://www.myvue.com/-/media/9a0486a0002f46548f04f032c351b6a2.png?/w780",
            "PG",
            "Chris Pratt, Anya Taylor-Joy, Charlie Day, Jack Black, Seth Rogen",
            "A plumber named Mario travels through an underground labyrinth with his brother, Luigi, trying to save a captured princess..",
            "1hr 32mins",
            "",
            0,
            8
        )
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
            14
        )
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
            7
        )
        Movie(
            6,
            "EVIL DEAD RISE",
            "https://www.myvue.com/-/media/757c322eb6a944de8be9aa9c0a9455b1.png?/w780",
            "18",
            "Gabrielle Echols, Lily Sullivan, Alyssa Sutherland",
            "Moving the action out of the woods and into the city, 'Evil Dead Rise' tells the twisted tale of two estranged sisters whose reunion is cut short by the rise of flesh-possessing demons.",
            "1hr 37mins",
            "",
            0,
            13
        )



        binding.movieTitle.text = movie.title
        binding.movieDescription.text = movie.description
        binding.movieActors.text = movie.actors
        binding.movieCertification.text = movie.certification
        binding.movieRunningTime.text = movie.runningTime
        binding.selectedSeats.text = movie.seatsSelected.toString()
        binding.movieSeatsRemaining.text = movie.seatsRemaining.toString()

        binding.minusButton.setOnClickListener {
            if (movie.seatsSelected > 0) {
                movie.seatsSelected--
                movie.seatsRemaining++
                binding.selectedSeats.text = movie.seatsSelected.toString()
                binding.movieSeatsRemaining.text = movie.seatsRemaining.toString()
            }
        }
        binding.plusButton.setOnClickListener {
            if (movie.seatsRemaining > 0) {
                movie.seatsSelected++
                movie.seatsRemaining--
                binding.selectedSeats.text = movie.seatsSelected.toString()
                binding.movieSeatsRemaining.text = movie.seatsRemaining.toString()
            }
        }
        Glide.with(binding.root)
            .load(movie.imageUrl)
            .into(binding.movieImage)

        // Check if the movie is sold out and set the text view accordingly
        if (movie.seatsRemaining == 0) {
            binding.movieSeatsRemaining.text = getString(R.string.sold_out)
        } else {
            binding.movieSeatsRemaining.text = movie.seatsRemaining.toString()
        }


        // Set back button click listener to pass the updated movie object back to the main activity
        binding.imgBtnBack.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("updatedMovie", movie)
            setResult(RESULT_OK, resultIntent)
            finish()
        }



        // Call the updateButtonStates method to set the initial button states
        updateButtonStates()


        // Set back button click listener to pass the updated movie object back to the main activity
        binding.imgBtnBack.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("updatedMovie", movie)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    // Update button states based on the number of seats selected and remaining
    fun updateButtonStates() {


    }

    // Override the back button to pass the updated movie object back to the main activity
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val movie: Movie? = intent.getSerializableExtra("movie") as? Movie
        if (movie != null) {
            val resultIntent = Intent().also {
                it.putExtra("updatedMovie", movie)
                setResult(Activity.RESULT_OK, it)
            }
        }
        super.onBackPressed()

    }


    private fun Intent.putExtra(s: String, movie: Movie) {


    }
}













