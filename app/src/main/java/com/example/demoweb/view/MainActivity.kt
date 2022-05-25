package com.example.demoweb.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.demoweb.R
import com.example.demoweb.databinding.ActivityMainBinding
import com.example.demoweb.model.DataStorage
import com.example.demoweb.presenter.BasePresenter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var presenter = BasePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.getData()
        initListeners()

    }

    private fun initListeners() {
        binding.btnNext.setOnClickListener()
        {
            if (presenter.checkIdsIsEmpty()) {
                Toast.makeText(this, "Please, wait loading data.", Toast.LENGTH_SHORT)
                    .show()
            } else presenter.getContent() { onResult ->

                when (presenter.checkTypeContent(onResult)) {
                    "text" -> {
                        findNavController(
                            R.id.container).navigate(R.id.textFragment)
                    }
                    "webview" -> {
                        findNavController(
                            R.id.container).navigate(R.id.webViewFragment)

                    }
                    "image" -> {
                        findNavController(
                            R.id.container).navigate(R.id.imageFragment)
                    }
                    "game" -> {
                        findNavController(
                            R.id.container).navigate(R.id.loadingFragment)
                    }
                    "null" -> {
                        Toast.makeText(this, "Non-existent content type!", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}