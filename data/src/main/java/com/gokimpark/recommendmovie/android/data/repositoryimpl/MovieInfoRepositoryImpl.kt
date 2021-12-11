package com.gokimpark.recommendmovie.android.data.repositoryimpl

import com.gokimpark.recommendmovie.android.data.remote.MovieInfoVolleyDataSource
import com.gokimpark.recommendmovie.android.domain.model.MovieInfo
import com.gokimpark.recommendmovie.android.domain.repository.MovieInfoRepository
import javax.inject.Inject

class MovieInfoRepositoryImpl @Inject constructor(
    private val movieInfoVolleyDataSource: MovieInfoVolleyDataSource
): MovieInfoRepository {

    override suspend fun getAny(): Result<MovieInfo> = movieInfoVolleyDataSource.getAnyMovieInfo()

}