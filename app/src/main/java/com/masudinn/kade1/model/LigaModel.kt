package com.masudinn.kade1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LigaModel (
    val name: String,
    val image: Int,
    val description: String)
    : Parcelable