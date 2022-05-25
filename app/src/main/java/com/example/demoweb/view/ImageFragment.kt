package com.example.demoweb.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.demoweb.databinding.FragmentImageBinding
import com.example.demoweb.presenter.BasePresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL


class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private var presenter = BasePresenter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentImageBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImageContent(presenter.setImageFragmentContent())
    }

    private fun setImageContent(url: String) {
        binding.imageHolder.loadUrl(presenter.loadUrl())

    }


}