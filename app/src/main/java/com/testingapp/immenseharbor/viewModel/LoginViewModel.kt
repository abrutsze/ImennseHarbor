package com.testingapp.immenseharbor.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testingapp.immenseharbor.data.models.LoginResponse
import com.testingapp.immenseharbor.data.repository.RepositoryHelper
import com.testingapp.immenseharbor.di.component.DIComponent
import com.testingapp.immenseharbor.utils.iomain
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginViewModel :ViewModel(),DIComponent.Injectable {

    var loginResult: MutableLiveData<LoginResponse> = MutableLiveData()
    var loginError: MutableLiveData<String> = MutableLiveData()
    var loginLoader: MutableLiveData<Boolean> = MutableLiveData()
    var compositeDisposable = CompositeDisposable();

    @Inject
    lateinit var repositoryHelper: RepositoryHelper

    override fun inject(diComponent: DIComponent) {
        diComponent.inject(this)
    }



    fun login(userName :String , password:String) {
        compositeDisposable.add(repositoryHelper.login(userName,password).iomain().subscribe({
            loginResult.postValue(it)
        },{
            loginError.postValue(it.message)
        }))
    }




    fun dispose(){
        compositeDisposable.clear()
    }
}