package com.testingapp.immenseharbor.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Region (
    val id : Int,
    val regionName : String
):Parcelable