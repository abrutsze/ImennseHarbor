package com.testingapp.immenseharbor.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.testingapp.immenseharbor.App
import com.testingapp.immenseharbor.di.component.DIComponent


class ViewModelFactory (private val app: App) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var t = super.create(modelClass)
        if (t is DIComponent.Injectable)
        {
            (t as DIComponent.Injectable).inject(app.di)
        }
        return t
    }
}