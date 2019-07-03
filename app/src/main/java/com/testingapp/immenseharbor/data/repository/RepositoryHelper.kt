package com.testingapp.immenseharbor.data.repository

import com.testingapp.immenseharbor.data.models.Department
import com.testingapp.immenseharbor.data.models.LoginResponse
import io.reactivex.Observable
import io.reactivex.Single

interface RepositoryHelper {

    fun login(userName :String , password:String):Observable<LoginResponse>
    fun departments():Observable<List<Department>>
    fun registered():Single<Int>

}