package com.example.sprint5

import android.os.Parcel
import android.os.Parcelable

data class Shoe(
    val name: String,
    val imageUrl: String,
    val price: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Shoe> {
        override fun createFromParcel(parcel: Parcel): Shoe {
            return Shoe(parcel)
        }

        override fun newArray(size: Int): Array<Shoe?> {
            return arrayOfNulls(size)
        }
    }
}