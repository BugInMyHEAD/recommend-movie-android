package com.gokimpark.recommendmovie.android.data.remote

import com.gokimpark.recommendmovie.android.domain.model.MovieInfo
import com.google.gson.annotations.SerializedName
import java.math.BigDecimal
import java.time.Year

internal class MovieInfoDto(
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("subtitle")
    val subtitle: String? = null,
    @SerializedName("pub_date")
    val publishedYear: String? = null,
    @SerializedName("image")
    val imageUrl: String? = null,
    @SerializedName("user_rating")
    val naverMovieUserRating: BigDecimal? = null,
    @SerializedName("link")
    val naverMovieUrl: String? = null,
    @SerializedName("director")
    val directors: String? = null,
    @SerializedName("actor")
    val actors: String? = null,
) {

    fun toMovieInfo() = MovieInfo(
        title = title,
        subtitle = subtitle,
        publishedYear = Year.parse(publishedYear),
        imageUrl = imageUrl,
        naverMovieUrl = naverMovieUrl,
        naverMovieUserRating = naverMovieUserRating,
        directors = directors?.split(",").orEmpty().map(String::trim),
        actors = actors?.split(",").orEmpty().map(String::trim),
    )

}