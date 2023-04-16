package com.example.movies4u

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies4u.databinding.ViewMovieItemsBinding

class MovieAdapter(private val movie: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ViewMovieItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }


    override fun getItemCount(): Int = movie.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movie[position])
    }

    class MovieViewHolder(private val binding: ViewMovieItemsBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MovieActivity::class.java)
                intent.putExtra(MovieActivity.MOVIE_ID, it.id)
                itemView.context.startActivity(intent, null)
            }
        }


        @SuppressLint("StringFormatInvalid")
        fun bind(movie: Movie) {
            binding.movieTitle.text = movie.title
            binding.movieActors.text = movie.actors
            binding.movieCertification.text = movie.certification
            binding.movieRunningTime.text = movie.runningTime
            binding.movieSeatsRemaining.text = movie.seatsRemaining.toString()
            Glide.with(itemView.context).load(movie.imageUrl).into(binding.movieImage)


            // Set the text color of the seats remaining text view
            when {
                movie.seatsSelected > 0 -> {
                    binding.movieSeatsRemaining.text = itemView.context.getString(R.string.select_seats, movie.seatsSelected)
                    binding.movieSeatsRemaining.setTextColor(Color.GREEN)
                    binding.movieSeatIcon.setColorFilter(Color.GREEN)
                }
                movie.seatsRemaining == 0 -> {
                    binding.movieSeatsRemaining.text =  itemView.context.getString(R.string.sold_out)
                    binding.movieSeatsRemaining.setTextColor(Color.parseColor("#CAC4D0"))
                    binding.movieSeatIcon.clearColorFilter()
                }
                else -> {
                    binding.movieSeatsRemaining.text = itemView.context.getString(R.string.select_seats, movie.seatsRemaining)
                    binding.movieSeatsRemaining.setTextColor(Color.parseColor("#CAC4D0"))
                    binding.movieSeatIcon.clearColorFilter()
                }
            }

// Show or hide the filling fast badge depending on the number of seats remaining
            val fillingFastBadge: TextView = binding.movieBadge
            if (movie.seatsRemaining in 1..2) {
                fillingFastBadge.visibility = View.VISIBLE
            } else {
                fillingFastBadge.visibility = View.GONE
            }


        }


    }

    companion object {
        fun updateMovie(it: Movie) {
            TODO("Not yet implemented")
        }
    }
}

