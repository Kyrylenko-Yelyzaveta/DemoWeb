package com.example.demoweb.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoweb.databinding.FragmentEmptyBinding
import com.example.demoweb.databinding.FragmentTextBinding

class EmptyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentEmptyBinding.inflate(inflater)
        return binding.root
    }

    companion object{}

}