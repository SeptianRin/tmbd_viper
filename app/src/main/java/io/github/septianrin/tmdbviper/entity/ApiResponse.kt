package io.github.septianrin.tmdbviper.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class ApiResponse (
    @SerializedName("page") var page : String? = null,
    @SerializedName("results") var results : List<MovieEntity> = mutableListOf(),
    @SerializedName("total_pages") var totalPages : String? = null,
    @SerializedName("total_results") var totalResults : String? = null,
):Parcelable