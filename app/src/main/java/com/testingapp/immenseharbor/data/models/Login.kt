package com.testingapp.immenseharbor.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Login(
    @SerializedName("username") val username : String,
    @SerializedName("password") val password : String,
    @SerializedName("rememberMe") val rememberMe : Boolean
):Parcelable