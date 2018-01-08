package com.cjwilliams24680.questiongenerator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cjwilliams24680.questiongenerator.R

/**
 * Created by chris on 12/21/17.
 */
class StarredQuestionsFragment : BaseFragment() {

    companion object {
        val TAG = "com.cjwilliams24680.questiongenerator.ui.StarredQuestionsFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_starred_questions, container, false)
    }

    override fun getNameTag(): String {
        return TAG
    }
}
