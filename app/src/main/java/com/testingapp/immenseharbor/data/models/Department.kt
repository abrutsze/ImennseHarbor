package com.testingapp.immenseharbor.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Department (
    @PrimaryKey
    val id : Int?,
    val departmentName : String?,
    val employees : String?,
    val location : Location?
):Parcelable