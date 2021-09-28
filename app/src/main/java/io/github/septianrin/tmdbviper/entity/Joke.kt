package io.github.septianrin.tmdbviper.entity

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Joke(
    @SerializedName("site") var site: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("desc") var desc: String? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("elementPureHtml") var elementPureHtml: String? = null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(site)
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeString(link)
        parcel.writeString(elementPureHtml)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Joke> {
        override fun createFromParcel(parcel: Parcel): Joke {
            return Joke(parcel)
        }

        override fun newArray(size: Int): Array<Joke?> {
            return arrayOfNulls(size)
        }
    }
}