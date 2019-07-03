package com.testingapp.immenseharbor.data.remote

import com.testingapp.immenseharbor.data.models.Department
import com.testingapp.immenseharbor.data.models.Login
import com.testingapp.immenseharbor.data.models.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface Api {

    @POST("authenticate")
    fun login(@Body login: Login):Observable<LoginResponse>

    @GET("departments")
    fun departments(@Header("Authorization") authorization : String):Observable<List<Department>>
}