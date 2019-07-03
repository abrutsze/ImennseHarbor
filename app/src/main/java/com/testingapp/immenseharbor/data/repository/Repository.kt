package com.testingapp.immenseharbor.data.repository

import android.content.Context
import com.testingapp.immenseharbor.data.database.AppDatabase
import com.testingapp.immenseharbor.data.models.Department
import com.testingapp.immenseharbor.data.models.Login
import com.testingapp.immenseharbor.data.models.LoginResponse
import com.testingapp.immenseharbor.data.prefrence.PreferenceHelper
import com.testingapp.immenseharbor.data.remote.Api
import com.testingapp.immenseharbor.utils.AppConstants
import com.testingapp.immenseharbor.utils.isNetworkConnected
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(private val context: Context, private val dataBase: AppDatabase, private val api: Api,
                                     private val preferenceHelper: PreferenceHelper) : RepositoryHelper {

    override fun registered(): Single<Int> = Single.just(preferenceHelper.getCurrentUserLoggedInMode())


    override fun login(userName: String, password: String): Observable<LoginResponse> {
        return api.login(Login(userName,password,true)).doOnNext {
            preferenceHelper.setCurrentUserToken(it.id_token)
            preferenceHelper.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
        }
    }


    override fun departments(): Observable<List<Department>> {
        var hasConnection  = isNetworkConnected(context)
        var observableFromApi: Observable<List<Department>>? = null
        if (hasConnection) {
            observableFromApi = getDepartmentFromApi()
        }

        var observableFromDb = getDepartmentFromDb()

        return if (hasConnection) Observable.concatArrayEager(observableFromApi,observableFromDb )
        else observableFromDb
    }


    private fun getDepartmentFromApi(): Observable<List<Department>> {
        return api.departments("Bearer ${preferenceHelper.getCurrentUserToken()}").doOnNext {

            for (item in it!!) {
                item?.apply {
                    dataBase.departmentDao.insert(item)
                }
            }
        }
    }

    private fun getDepartmentFromDb(): Observable<List<Department>>{
        return dataBase.departmentDao.result().toObservable()
    }

}