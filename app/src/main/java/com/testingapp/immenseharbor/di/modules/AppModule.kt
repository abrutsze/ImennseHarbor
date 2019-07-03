package com.testingapp.immenseharbor.di.modules

import android.content.Context
import androidx.room.Room
import com.testingapp.immenseharbor.App
import com.testingapp.immenseharbor.data.database.AppDatabase
import com.testingapp.immenseharbor.data.prefrence.AppPreferenceHelper
import com.testingapp.immenseharbor.data.prefrence.PreferenceHelper
import com.testingapp.immenseharbor.data.repository.Repository
import com.testingapp.immenseharbor.data.repository.RepositoryHelper
import com.testingapp.immenseharbor.di.annotations.PreferenceInfo
import com.testingapp.immenseharbor.utils.AppConstants
import com.testingapp.immenseharbor.utils.AppConstants.PREF_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    fun providesApp(): App = app

    @Provides
    @Singleton
    internal fun provideContext(): Context =app.applicationContext


    @Singleton
    @Provides
    internal fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DB_NAME).build()
    }



    @Singleton
    @Provides
    internal fun providesRepositoryHelper(repository: Repository):RepositoryHelper  = repository

    @Provides
    @PreferenceInfo
    internal fun providesPrefFileName(): String = PREF_NAME


    @Provides
    @Singleton
    internal fun providesPrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper
}