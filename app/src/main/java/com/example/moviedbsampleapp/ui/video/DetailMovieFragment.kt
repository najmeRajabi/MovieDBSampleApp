package com.example.moviedbsampleapp.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.databinding.FragmentDetailMovieBinding

class DetailMovieFragment : Fragment() {
    val vModel : MovieViewModel by viewModels()
    lateinit var binding: FragmentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail_movie, container, false)

        binding.vModel = vModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

}