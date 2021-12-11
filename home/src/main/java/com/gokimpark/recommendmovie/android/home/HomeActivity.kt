package com.gokimpark.recommendmovie.android.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.gokimpark.recommendmovie.android.home.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModels<HomeViewModel>()
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        subscribeMovieInfo()
        binding.findAnotherButton.setOnClickListener { viewModel.loadMovieInfo() }
    }

    private fun subscribeMovieInfo() = lifecycleScope.launch {
        viewModel.movieInfoStateFlow.collectLatest { result ->
            result.onSuccess { movieInfo ->
                binding.movieInfo = movieInfo
                binding.throwable = null
            }.onFailure { throwable ->
                binding.throwable = throwable
                binding.movieInfo = null
            }
        }
    }

}