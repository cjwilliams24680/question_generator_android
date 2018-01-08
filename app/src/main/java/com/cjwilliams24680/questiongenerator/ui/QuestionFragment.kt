package com.cjwilliams24680.questiongenerator.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.cjwilliams24680.questiongenerator.R
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by chris on 12/21/17.
 */
class QuestionFragment : BaseFragment() {

    companion object {
        val TAG = "com.cjwilliams24680.questiongenerator.ui.QuestionFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view!!.findViewById<Button>(R.id.new_question_button).setOnClickListener({getNewQuestion()})
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getNameTag(): String {
        return TAG
    }

    private fun getNewQuestion() {
        getCallback()!!
                .getNetwork()!!
                .question
                .enqueue(object : Callback<JSONObject> {
                    override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                        updateQuestion(response.body()!!.getString("question"))
                    }

                    override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                        updateQuestion("An Error Occurred")
                    }
                })
    }

    private fun updateQuestion(newQuestion: String?) {
        if (isResumed) {
            view.findViewById<TextView>(R.id.question_text).text = newQuestion
        }
    }
}
