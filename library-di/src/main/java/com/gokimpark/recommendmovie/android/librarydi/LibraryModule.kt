package com.gokimpark.recommendmovie.android.librarydi

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.gokimpark.recommendmovie.android.data.remote.MovieInfoVolleyDataSource
import com.gokimpark.recommendmovie.android.data.repositoryimpl.MovieInfoRepositoryImpl
import com.gokimpark.recommendmovie.android.domain.repository.MovieInfoRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LibraryModule {

    @Provides
    fun provideRequestQueue(@ApplicationContext context: Context): RequestQueue = Volley.newRequestQueue(context)

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideMovieInfoVolleyDataSource(
        requestQueue: RequestQueue,
        gson: Gson
    ) = MovieInfoVolleyDataSource(
        requestQueue, gson
    )

    @Provides
    fun provideMovieInfoRepository(
        movieInfoVolleyDataSource: MovieInfoVolleyDataSource
    ): MovieInfoRepository = MovieInfoRepositoryImpl(
        movieInfoVolleyDataSource
    )

}