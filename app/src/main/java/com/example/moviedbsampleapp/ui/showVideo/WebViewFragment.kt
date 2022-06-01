package com.example.moviedbsampleapp.ui.showVideo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.moviedbsampleapp.R
import com.example.moviedbsampleapp.databinding.FragmentWebViewBinding
import com.example.moviedbsampleapp.ui.video.DetailMovieFragmentArgs

class WebViewFragment : Fragment() {

    lateinit var binding: FragmentWebViewBinding
    val vModel: VideoViewModel by viewModels()
    private val args: WebViewFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,R.layout.fragment_web_view, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val link = args.link
        binding.lifecycleOwner= viewLifecycleOwner
        binding.webView.loadUrl(link)
    }

}