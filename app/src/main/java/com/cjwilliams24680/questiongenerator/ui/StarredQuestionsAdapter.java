package com.cjwilliams24680.questiongenerator.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.cjwilliams24680.questiongenerator.R;
import com.cjwilliams24680.questiongenerator.constants.StarredQuestionsViewTypes;
import com.cjwilliams24680.questiongenerator.databinding.HeaderCellBinding;
import com.cjwilliams24680.questiongenerator.databinding.QuestionCellBinding;
import com.cjwilliams24680.questiongenerator.datastore.PreferencesState;
import com.cjwilliams24680.questiongenerator.datastore.StarredQuestionsState;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Adapter for handling the views on the StarredQuestions page
 */

public class StarredQuestionsAdapter extends RecyclerView.Adapter implements QuestionHolder.Callback {

    private final List<String> questions;
    private final String userName;

    // Don't want to hold a reference to the context directly or we might leak the activity
    private WeakReference<Context> context;

    public StarredQuestionsAdapter(WeakReference<Context> context) {
        this.userName = PreferencesState.Companion.getInstance(context.get()).getCurrentUser();
        this.questions = new StarredQuestionsState(context.get(), userName).getQuestions();
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, @StarredQuestionsViewTypes int viewType) {
        if (viewType == StarredQuestionsViewTypes.QUESTION) {
            return new QuestionHolder(QuestionCellBinding.inflate(LayoutInflater.from(parent.getContext())));
        } else {
            HeaderCellBinding binding = HeaderCellBinding.inflate(LayoutInflater.from(parent.getContext()));
            binding.text.setText(R.string.starred_questions);
            return new ConstantViewHolder(binding.getRoot());
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            // If it's the header we don't need to do anything
            return;
        }

        int positionInQuestions = position - 1;

        ((QuestionHolder) holder).update(questions.get(positionInQuestions), positionInQuestions, this);
    }

    @Override
    public int getItemCount() {
        return questions.size() + 1;
    }

    public @StarredQuestionsViewTypes int getItemViewType(int position) {
        return position == 0 ? StarredQuestionsViewTypes.HEADER : StarredQuestionsViewTypes.QUESTION;
    }

    @Override
    public void onStarClicked(int position) {
        String questionsName = questions.get(position);
        questions.remove(position);
        notifyItemRemoved(position + 1);

        new StarredQuestionsState(context.get(), userName).removeQuestion(questionsName);
    }
}
