package com.testingapp.immenseharbor.data.prefrence

import com.testingapp.immenseharbor.utils.AppConstants

interface PreferenceHelper {
    fun getCurrentUserToken():String?
    fun setCurrentUserToken(token :String)
    fun getCurrentUserLoggedInMode(): Int
    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)
}