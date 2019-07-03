package com.testingapp.immenseharbor.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val id : Int,
    val streetAddress : String,
    val postalCode : Int,
    val city : String,
    val stateProvince : String,
    val country : Country
):Parcelable