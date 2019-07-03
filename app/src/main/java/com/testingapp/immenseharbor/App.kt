package com.testingapp.immenseharbor

import android.app.Application
import com.testingapp.immenseharbor.di.component.DIComponent
import com.testingapp.immenseharbor.di.component.DaggerDIComponent
import com.testingapp.immenseharbor.di.modules.ApiModule
import com.testingapp.immenseharbor.di.modules.AppModule

class App : Application() {

    lateinit var di : DIComponent
    override fun onCreate() {
        super.onCreate()

        di = DaggerDIComponent
            .builder()
            .apiModule(ApiModule())
            .appModule(AppModule(this))
            .build()
    }
}