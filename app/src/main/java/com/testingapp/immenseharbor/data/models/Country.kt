package com.testingapp.immenseharbor.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country (
    val id : Int,
    val countryName : String,
    val region : Region
):Parcelable