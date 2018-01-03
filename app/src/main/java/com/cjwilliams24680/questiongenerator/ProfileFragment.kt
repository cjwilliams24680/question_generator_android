package com.cjwilliams24680.questiongenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by chris on 12/21/17.
 */
class ProfileFragment : BaseFragment() {

    companion object {
        val TAG = "com.cjwilliams24680.questiongenerator.ProfileFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun getNameTag(): String {
        return TAG
    }

}
