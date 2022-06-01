package com.example.moviedbsampleapp.ui.videoList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.databinding.FragmentMovieListBinding
import com.example.moviedbsampleapp.ui.adapters.MoviesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {

    val vModel: MovieListViewModel by viewModel()
    lateinit var binding: FragmentMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
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
            findNavController().navigate(MovieListFragmentDirections.
            actionMovieListFragmentToDetailMovieFragment(it.id))
            Toast.makeText(requireContext(),"clicked on ${it.title}",Toast.LENGTH_SHORT).show()
        }
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vModel.movieList.observe(viewLifecycleOwner){ movie ->
            if (movie == null){
                Toast.makeText(requireContext(),"not movie yet", Toast.LENGTH_LONG).show()
            }else{
            binding.adaptor!!.submitList(movie)
            }
        }

        binding.searchEdtHome.addTextChangedListener {
            vModel.searchMovies(it.toString())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.comingSoonVideosFragment -> {
                findNavController().navigate(R.id.action_movieListFragment_to_comingSoonVideosFragment)
                true}
            else -> super.onOptionsItemSelected(item)

        }
    }

}