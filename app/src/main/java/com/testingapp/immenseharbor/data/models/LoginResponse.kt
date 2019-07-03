package com.testingapp.immenseharbor.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class LoginResponse (
    val id_token:String
):Parcelable