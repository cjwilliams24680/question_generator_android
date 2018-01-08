package com.cjwilliams24680.questiongenerator.network;

import retrofit2.Retrofit;

/**
 * Created by chris on 1/7/18.
 *
 * todo would like to convert this to kotlin
 */

public class NetworkUtils {

    public static QuestionsApi createNetworkObject() {
        return new Retrofit.Builder()
                .baseUrl("localhost:5000/")
                .build()
                .create(QuestionsApi.class);
    }
}
