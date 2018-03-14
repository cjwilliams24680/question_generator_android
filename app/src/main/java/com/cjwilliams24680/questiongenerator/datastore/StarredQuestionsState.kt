package com.cjwilliams24680.questiongenerator.datastore

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by chris on 12/21/17.
 *
 * acts like a bunch of 1 column tables in a database
 * todo move it inside of a database and make it more efficient
 */
class StarredQuestionsState(context: Context, userName: String) {

    companion object {
        private val TAG = "com.cjwilliams24680.questiongenerator.datastore.StarredQuestionsState"
    }

    private var sharedPrefs: SharedPreferences

    init {
        sharedPrefs = context.getSharedPreferences(String.format("%s|%s", TAG, userName), Context.MODE_PRIVATE)
    }

    fun getQuestions(): List<String> {
        return ArrayList(sharedPrefs.all.keys)
    }

    fun addQuestion(question: String) {
        sharedPrefs.edit().putString(question, "").apply()
    }

    fun removeQuestion(question: String) {
        sharedPrefs.edit().remove(question).apply()
    }

    fun contains(question: String): Boolean {
        return sharedPrefs.contains(question)
    }

}
