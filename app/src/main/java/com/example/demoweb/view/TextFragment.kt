package com.example.demoweb.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoweb.databinding.FragmentImageBinding
import com.example.demoweb.databinding.FragmentTextBinding
import com.example.demoweb.presenter.BasePresenter


class TextFragment : Fragment() {
    private  lateinit var binding: FragmentTextBinding
    private  var presenter = BasePresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTextBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.header.text = presenter.setTextFragment()

    }





}