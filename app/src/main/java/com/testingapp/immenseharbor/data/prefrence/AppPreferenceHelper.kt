package com.testingapp.immenseharbor.data.prefrence

import android.content.Context
import android.content.SharedPreferences
import com.testingapp.immenseharbor.di.annotations.PreferenceInfo
import com.testingapp.immenseharbor.utils.AppConstants
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferenceInfo private val prefFileName: String): PreferenceHelper {

    companion object {
        private const val PREF_KEY_TOKEN = "PREF_KEY_TOKEN"
        private const val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"

    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserToken(): String? = mPrefs.getString(PREF_KEY_TOKEN,"" )

    override fun setCurrentUserToken(token :String) {
        mPrefs.edit().putString(PREF_KEY_TOKEN, token).apply()
    }

    override fun getCurrentUserLoggedInMode() = mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE,  mode.type).apply()
    }


}