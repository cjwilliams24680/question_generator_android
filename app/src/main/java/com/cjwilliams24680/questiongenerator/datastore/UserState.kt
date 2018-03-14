package com.cjwilliams24680.questiongenerator.datastore

import android.content.Context
import android.content.SharedPreferences
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by chris on 12/21/17.
 *
 * acts like a 1 column table in a database
 * todo move it inside of a database and make it more efficient
 *
 */
class UserState(context: Context) {

    companion object {
        private val TAG = "com.cjwilliams24680.questiongenerator.datastore.UserState"

        private var INSTANCE: UserState? = null

        fun getInstance(context: Context): UserState {
            return INSTANCE ?: UserState(context)
        }
    }

    private var sharedPrefs: SharedPreferences

    init {
        sharedPrefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)
    }

    /**
     * @return true if a new user, false if user exists already
     */
    fun addUser(name: String): Boolean {
        if (sharedPrefs.contains(name)) {
            return false
        }

        sharedPrefs.edit().putString(name, UUID.randomUUID().toString()).apply()
        return true
    }

    fun getUsers(name: String): List<String> {
        return ArrayList(sharedPrefs.all.keys)
    }
}