package com.cjwilliams24680.questiongenerator.ui

import android.support.v4.app.Fragment
import java.lang.ref.WeakReference

/**
 * Created by chris on 1/3/18.
 */
abstract class BaseFragment : Fragment() {

    // Wrapped in a weak reference to guard against accidental memory leaks
    private var callback: WeakReference<MainActivityCallback> = WeakReference<MainActivityCallback>(null)

    fun setCallback(callback: MainActivityCallback) {
        this.callback = WeakReference(callback)
    }

    fun getCallback(): MainActivityCallback? {
        return callback.get()
    }

    abstract fun getNameTag(): String

    override fun onStop() {
        getCallback()!!.showProgressSpinner(false)
        super.onStop()
    }
}