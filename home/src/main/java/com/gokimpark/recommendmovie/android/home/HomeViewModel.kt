package com.gokimpark.recommendmovie.android.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gokimpark.recommendmovie.android.domain.model.MovieInfo
import com.gokimpark.recommendmovie.android.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val movieInfoMutableStateFlow: MutableStateFlow<Result<MovieInfo>> = MutableStateFlow(loadingMovieInfo)
    val movieInfoStateFlow: StateFlow<Result<MovieInfo>> = movieInfoMutableStateFlow

    init {
        loadMovieInfo()
    }

    fun loadMovieInfo() = viewModelScope.launch {
        val movieInfo = useCase.getAnyMovieInfo()
        movieInfoMutableStateFlow.value = movieInfo
    }

    companion object {
        private val loadingException = RuntimeException("Loading...")
        private val loadingMovieInfo = Result.failure<MovieInfo>(loadingException)
    }

}