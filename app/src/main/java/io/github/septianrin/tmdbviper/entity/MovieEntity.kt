package io.github.septianrin.tmdbviper.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
class MovieEntity (
    @SerializedName("title") var title: String? = null,
    @SerializedName("release_date") var releaseDate : String? = null,
    @SerializedName("popularity") var popularity : String? = null,
    @SerializedName("overview") var overview : String? = null,
    ):Parcelable