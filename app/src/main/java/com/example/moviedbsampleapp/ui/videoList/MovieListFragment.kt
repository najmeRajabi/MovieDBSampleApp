package com.example.moviedbsampleapp.ui.videoList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.databinding.FragmentMovieListBinding
import com.example.moviedbsampleapp.ui.adapters.MoviesAdapter

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
        binding.adaptor = MoviesAdapter {
            Toast.makeText(requireContext(),"clicked on ${it.title}",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_movieListFragment_to_comingSoonVideosFragment)
        }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vModel.movieList.observe(viewLifecycleOwner){
            if (it == null){
                Toast.makeText(requireContext(),"not movie yet", Toast.LENGTH_LONG).show()
            }else{
            binding.adaptor!!.submitList(it)
            }
        }

        binding.searchEdtHome.addTextChangedListener {
            vModel.searchMovies(it.toString())
        }
    }

}