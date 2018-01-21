package com.cjwilliams24680.questiongenerator.ui

import com.cjwilliams24680.questiongenerator.network.QuestionsApi

/**
 * Created by chris on 1/3/18.
 */
interface MainActivityCallback {

    fun getNetwork(): QuestionsApi?

    fun showProgressSpinner(isVisible: Boolean)

}