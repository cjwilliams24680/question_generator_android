package com.cjwilliams24680.questiongenerator

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by chris on 12/21/17.
 *
 * acts like a 2 column table in a database
 * todo move it inside of a database
 */
class StarredQuestionsState {

    companion object {
        private val TAG = "com.cjwilliams24680.questiongenerator.StarredQuestionsState"
    }

    private var sharedPrefs: SharedPreferences? = null

    fun main(context: Context, userId: String) {
        sharedPrefs = context.getSharedPreferences(String.format("%s/%s", TAG, userId), Context.MODE_PRIVATE)
    }

}