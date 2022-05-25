package com.example.moviedbsampleapp.ui.upComing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.databinding.FragmentComingSoonVideosBinding
import com.example.moviedbsampleapp.ui.adapters.MoviesAdapter


class ComingSoonVideosFragment : Fragment() {

    val vModel : ComingSoonViewModel by viewModels()
    lateinit var binding: FragmentComingSoonVideosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_coming_soon_videos , container , false)
        binding.adaptor = MoviesAdapter {  }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vModel.upComingVideos.observe(viewLifecycleOwner){
            binding.adaptor!!.submitList(it)
        }
    }
}