package com.cjwilliams24680.questiongenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by chris on 12/21/17.
 */
class MainActivity : AppCompatActivity(), MainActivityCallback {

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchFragment(QuestionFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    fun launchFragment(fragment: BaseFragment) {
        fragment.setCallback(this)
        fragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.getNameTag()).commit()
    }
}
