package com.cjwilliams24680.questiongenerator

import android.content.Context
import android.content.SharedPreferences
import java.util.*

/**
 * Created by chris on 12/21/17.
 *
 * acts like a 2 column table in a database
 * todo move it inside of a database
 *
 */
class UserState {

    companion object {
        private val TAG = "com.cjwilliams24680.questiongenerator.UserState"
        private val USER_NAME = "UserState.USER_NAME"
    }

    private var sharedPrefs: SharedPreferences? = null

    fun main(context: Context) {
        sharedPrefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }

    fun createUser(name: String): Boolean {
        if (sharedPrefs!!.contains(name)) {
            return false
        }

        sharedPrefs!!.edit().putString(name, UUID.randomUUID().toString()).apply()
        return true
    }
}