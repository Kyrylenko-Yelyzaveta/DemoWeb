package com.example.demoweb.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoweb.databinding.FragmentImageBinding
import com.example.demoweb.databinding.FragmentTextBinding
import com.example.demoweb.databinding.FragmentWebViewBinding
import com.example.demoweb.presenter.BasePresenter

class WebViewFragment : Fragment() {
    private  lateinit var binding: FragmentWebViewBinding
    private  var presenter = BasePresenter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentWebViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.loadUrl(presenter.loadUrl())
    }

    companion object{}

}