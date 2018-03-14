package com.cjwilliams24680.questiongenerator.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * For static view holders which take an initial view and then never need to be updated
 */

public class ConstantViewHolder extends RecyclerView.ViewHolder {

    public ConstantViewHolder(View itemView) {
        super(itemView);
    }

}
