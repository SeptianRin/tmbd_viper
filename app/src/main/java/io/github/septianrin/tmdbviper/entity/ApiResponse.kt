package io.github.septianrin.tmdbviper.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class ApiResponse (
    @SerializedName("page") var page : String? = null,
    @SerializedName("results") var results : String? = null,
    @SerializedName("total_pages") var totalPages : String? = null,
    @SerializedName("total_results") var totalResults : String? = null,
):Parcelable