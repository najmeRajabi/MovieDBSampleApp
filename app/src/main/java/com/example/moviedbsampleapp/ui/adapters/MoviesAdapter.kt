package com.example.moviedbsampleapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.model.Movie


typealias ClickHandler = (movie: Movie) -> Unit

class MoviesAdapter( var clickHandler : ClickHandler):
        ListAdapter<Movie, MoviesAdapter.ViewHolder>(WordDiffCallback) {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_item_row, parent, false)


            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: MoviesAdapter.ViewHolder, position: Int) {
            holder.bind(getItem(position) , clickHandler )


        }

        object WordDiffCallback : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }
        }


        class ViewHolder( val view: View): RecyclerView.ViewHolder(view) {
            val txvTitle = view.findViewById<TextView>(R.id.txv_title_poster)
            val imvPoster = view.findViewById<ImageView>(R.id.imv_poster_item)


            fun bind(
                movie: Movie,
                clickHandler: ClickHandler
            ) {

                txvTitle.text = movie.title
                Glide
                    .with(view)
                    .load(movie.posterPath)
                    .centerCrop()
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .into(imvPoster)

                view.setOnClickListener { clickHandler(movie) }

            }
        }
}