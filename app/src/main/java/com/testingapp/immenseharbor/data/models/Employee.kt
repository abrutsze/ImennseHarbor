package com.testingapp.immenseharbor.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Employee (
    val id : Int?,
    val firstName : String?,
    val lastName : String?,
    val email : String?,
    val phoneNumber : Int?,
    val hireDate : String?,
    val salary : Int?,
    val commissionPct : Int?,
    val jobs : String?,
    val manager : String?
):Parcelable