package com.cjwilliams24680.questiongenerator.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cjwilliams24680.questiongenerator.R
import com.cjwilliams24680.questiongenerator.databinding.FragmentQuestionBinding
import com.cjwilliams24680.questiongenerator.datastore.PreferencesState
import com.cjwilliams24680.questiongenerator.datastore.StarredQuestionsState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by chris on 12/21/17.
 */
class QuestionFragment : BaseFragment() {

    var binding: FragmentQuestionBinding? = null
    var starredQuestionsState: StarredQuestionsState? = null

    companion object {
        val TAG = "com.cjwilliams24680.questiongenerator.ui.QuestionFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false)
        starredQuestionsState = StarredQuestionsState(context, PreferencesState.getInstance(context).getCurrentUser())
        return binding!!.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        binding!!.nextButton.setOnClickListener({getNewQuestion()})
        binding!!.starButton.setOnClickListener({starQuestion(binding!!.questionText.text.toString())})

        // update ui
        getNewQuestion()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getNameTag(): String {
        return TAG
    }

    private fun getNewQuestion() {
        getCallback()!!.showProgressSpinner(true)
        getCallback()!!
                .getNetwork()!!
                .question
                .enqueue(object : Callback<String> {
                    override fun onResponse(call: Call<String>, response: Response<String>) {
                        updateQuestion(response.body())
                    }

                    override fun onFailure(call: Call<String>, t: Throwable) {
                        updateQuestion("An Error Occurred")
                    }
                })
    }

    private fun updateQuestion(newQuestion: String?) {
        if (isResumed) {
            getCallback()!!.showProgressSpinner(false)
            binding!!.questionText.text = newQuestion
            binding!!.isStarred = starredQuestionsState!!.contains(newQuestion!!)
        }
    }

    private fun starQuestion(starredQuestion: String) {
        binding!!.isStarred = !binding!!.isStarred
        starredQuestionsState!!.addQuestion(starredQuestion)
    }
}
