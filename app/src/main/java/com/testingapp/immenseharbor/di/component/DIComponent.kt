package com.testingapp.immenseharbor.di.component

import androidx.annotation.Keep
import com.testingapp.immenseharbor.di.modules.ApiModule
import com.testingapp.immenseharbor.di.modules.AppModule
import com.testingapp.immenseharbor.viewModel.LoginViewModel
import com.testingapp.immenseharbor.viewModel.MainViewModel
import com.testingapp.immenseharbor.viewModel.SplashViewModel
import dagger.Component
import javax.inject.Singleton

@Keep
@Singleton
@Component(modules = [AppModule::class , ApiModule::class])
interface DIComponent {

    interface Injectable{
        fun inject(diComponent: DIComponent)
    }

    fun inject(mainViewModel: MainViewModel)
    fun inject(loginViewModel: LoginViewModel)
    fun inject(splashViewModel: SplashViewModel)

}