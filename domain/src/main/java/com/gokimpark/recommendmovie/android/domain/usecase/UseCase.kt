package com.gokimpark.recommendmovie.android.domain.usecase

import com.gokimpark.recommendmovie.android.domain.model.MovieInfo
import com.gokimpark.recommendmovie.android.domain.repository.MovieInfoRepository
import javax.inject.Inject

class UseCase @Inject constructor(
    private val movieInfoRepository: MovieInfoRepository
) {

    suspend fun getAnyMovieInfo(): Result<MovieInfo> = movieInfoRepository.getAny()

}