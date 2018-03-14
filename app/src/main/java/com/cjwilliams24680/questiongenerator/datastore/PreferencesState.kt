package com.cjwilliams24680.questiongenerator.datastore

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by chris on 12/21/17.
 *
 * For storing misc things about the user's state
 */
class PreferencesState(context: Context) {

    companion object {
        private val TAG = "com.cjwilliams24680.questiongenerator.datastore.PreferencesState"
        private val CURRENT_USER_KEY = "PreferencesState.CURRENT_USER_KEY"
        val DEFAULT_USER = "Default User"

        private var INSTANCE: PreferencesState? = null

        fun getInstance(context: Context): PreferencesState {
            return INSTANCE ?: PreferencesState(context)
        }
    }

    private var sharedPrefs: SharedPreferences

    init {
        sharedPrefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }

    fun getCurrentUser(): String {
        return sharedPrefs.getString(CURRENT_USER_KEY, DEFAULT_USER)
    }

}