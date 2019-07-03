package com.testingapp.immenseharbor.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.testingapp.immenseharbor.data.models.Department
import com.testingapp.immenseharbor.data.repository.RepositoryHelper
import com.testingapp.immenseharbor.di.component.DIComponent
import com.testingapp.immenseharbor.utils.iomain
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel :ViewModel(),DIComponent.Injectable {

    var departmentsResult: MutableLiveData<List<Department>> = MutableLiveData()
    var departmentsError: MutableLiveData<String> = MutableLiveData()
    var departmentsLoader: MutableLiveData<Boolean> = MutableLiveData()
    var compositeDisposable = CompositeDisposable();

    @Inject
    lateinit var repositoryHelper: RepositoryHelper

    override fun inject(diComponent: DIComponent) {
        diComponent.inject(this)
    }



    fun departments() {
        compositeDisposable.add(repositoryHelper.departments().iomain().subscribe({
            departmentsResult.postValue(it)
        },{
            departmentsError.postValue(it.message)
        }))
    }




    fun dispose(){
        compositeDisposable.clear()
    }
}