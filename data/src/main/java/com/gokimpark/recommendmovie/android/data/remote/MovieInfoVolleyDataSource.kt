package com.gokimpark.recommendmovie.android.data.remote

import com.android.volley.RequestQueue
import com.android.volley.toolbox.RequestFuture
import com.gokimpark.recommendmovie.android.domain.model.MovieInfo
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MovieInfoVolleyDataSource @Inject constructor(
    private val requestQueue: RequestQueue,
    private val gson: Gson
) {

    suspend fun getAnyMovieInfo(): Result<MovieInfo> = withContext(Dispatchers.IO) {
        val requestFuture = RequestFuture.newFuture<MovieInfoDto>()
        val request = GsonGetRequest(
            gson,
            Configs.MOVIE_INFO_URL,
            null,
            requestFuture::onResponse,
            requestFuture::onErrorResponse
        )
        requestQueue.add(request)
        return@withContext runCatching { requestFuture.get(5, TimeUnit.SECONDS).toMovieInfo() }
    }

}