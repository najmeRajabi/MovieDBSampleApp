package com.example.moviedbsampleapp.ui.videoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment() {

    val vModel: MovieListViewModel by viewModels()
    lateinit var binding: FragmentMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,
            R.layout.fragment_movie_list, container, false)

        binding.viewModel = vModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

}