package com.gokimpark.recommendmovie.android.domain.repository

import com.gokimpark.recommendmovie.android.domain.model.MovieInfo

interface MovieInfoRepository {

    suspend fun getAny(): Result<MovieInfo>

}