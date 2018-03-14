package com.cjwilliams24680.questiongenerator.ui;

import android.support.v7.widget.RecyclerView;

import com.cjwilliams24680.questiongenerator.databinding.QuestionCellBinding;

/**
 * Created by chris on 3/13/18.
 */

public class QuestionHolder extends RecyclerView.ViewHolder {

    public interface Callback {
        void onStarClicked(int position);
    }

    private int position;
    private QuestionCellBinding binding;

    public QuestionHolder(QuestionCellBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void update(String question, int position, final Callback callback) {
        this.position = position;
        binding.question.setText(question);
        binding.starButton.setOnClickListener(v -> callback.onStarClicked(this.position));
    }

}
