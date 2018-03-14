package com.cjwilliams24680.questiongenerator.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.cjwilliams24680.questiongenerator.R
import com.cjwilliams24680.questiongenerator.network.NetworkUtils
import com.cjwilliams24680.questiongenerator.network.QuestionsApi
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by chris on 12/21/17.
 */
class MainActivity : AppCompatActivity(), MainActivityCallback {

    override fun showProgressSpinner(isVisible: Boolean) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNetwork(): QuestionsApi? {
        return api
    }

    // Would normally use dependency injection (like dagger) to maintain this as a singleton throughout the application
    // However for this use case (1 activity) it is not necessary yet
    private var api: QuestionsApi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        api = NetworkUtils.createNetworkObject()

        setContentView(R.layout.activity_main)
        launchFragment(QuestionFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun launchFragment(fragment: BaseFragment) {
        fragment.setCallback(this)
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.getNameTag()).commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_questions -> {
                launchFragment(QuestionFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_starred -> {
                launchFragment(StarredQuestionsFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                launchFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
