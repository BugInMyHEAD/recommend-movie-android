package com.gokimpark.recommendmovie.android.domain.model

import java.math.BigDecimal
import java.time.Year

data class MovieInfo(
    val title: String? = null,
    val subtitle: String? = null,
    val publishedYear: Year? = null,
    val imageUrl: String? = null,
    val naverMovieUrl: String? = null,
    val naverMovieUserRating: BigDecimal? = null,
    val directors: List<String> = emptyList(),
    val actors: List<String> = emptyList(),
)