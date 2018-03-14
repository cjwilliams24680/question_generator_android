package com.cjwilliams24680.questiongenerator.constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by chris on 3/13/18.
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        StarredQuestionsViewTypes.HEADER,
        StarredQuestionsViewTypes.QUESTION,
})

public @interface StarredQuestionsViewTypes {
    int HEADER = 0;
    int QUESTION = 1;
}
