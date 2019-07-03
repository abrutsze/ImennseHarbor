package com.testingapp.immenseharbor.utils

object AppConstants {
    const val DB_NAME = "ih.db"
    const val BASE_URL = "https://immense-harbor-92209.herokuapp.com/api/"
    const val PREF_NAME = "com.ppa.app.utils.Constants_pref"

    enum class LoggedInMode constructor(val type : Int){
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1)
    }

}