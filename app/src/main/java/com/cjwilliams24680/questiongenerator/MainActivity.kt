package com.cjwilliams24680.questiongenerator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by chris on 12/21/17.
 */
class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_questions -> {
                fragmentManager.beginTransaction().replace(R.id.container, QuestionFragment(), QuestionFragment.TAG).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_starred -> {
                fragmentManager.beginTransaction().replace(R.id.container, StarredQuestionsFragment(), StarredQuestionsFragment.TAG).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                fragmentManager.beginTransaction().replace(R.id.container, ProfileFragment(), ProfileFragment.TAG).commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager.beginTransaction().replace(R.id.container, QuestionFragment(), QuestionFragment.TAG).commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
