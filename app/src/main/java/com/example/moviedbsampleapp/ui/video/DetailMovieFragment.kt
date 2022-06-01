package com.example.moviedbsampleapp.ui.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.databinding.FragmentDetailMovieBinding

class DetailMovieFragment : Fragment() {

    private val args: DetailMovieFragmentArgs by navArgs()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = args.id
        vModel.getMovie(id,requireContext())
        setImage()
        binding.imvPlayDetail.setOnClickListener {
            goToWebView(vModel.playVideo())
        }
    }

    private fun setImage() {
        vModel.movie.observe(viewLifecycleOwner) {
            Glide
                .with(requireActivity())
                .load("https://image.tmdb.org/t/p/w500" + it.posterPath)
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_more_horiz_24)
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .into(binding.imvPosterDetail)
        }
    }

    private fun goToWebView(link: String) {
        findNavController().navigate(DetailMovieFragmentDirections.actionDetailMovieFragmentToWebViewFragment(link))
    }

}