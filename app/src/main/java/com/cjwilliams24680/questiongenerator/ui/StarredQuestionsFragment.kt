package com.cjwilliams24680.questiongenerator.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cjwilliams24680.questiongenerator.databinding.FragmentStarredQuestionsBinding
import java.lang.ref.WeakReference

/**
 * Created by chris on 12/21/17.
 */
class StarredQuestionsFragment : BaseFragment() {

    companion object {
        val TAG = "com.cjwilliams24680.questiongenerator.ui.StarredQuestionsFragment"
    }

    private var binding: FragmentStarredQuestionsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStarredQuestionsBinding.inflate(inflater, container, false)
        binding!!.questionsList.adapter = StarredQuestionsAdapter(WeakReference(context))
        binding!!.questionsList.layoutManager = LinearLayoutManager(context)
        return binding!!.root
    }

    override fun getNameTag(): String {
        return TAG
    }
}
