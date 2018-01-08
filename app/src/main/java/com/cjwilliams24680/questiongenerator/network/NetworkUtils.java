package com.cjwilliams24680.questiongenerator.network;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by chris on 1/7/18.
 *
 * todo would like to convert this to kotlin
 */

public class NetworkUtils {

    public static QuestionsApi createNetworkObject() {
        return new Retrofit.Builder()
                .baseUrl("http://ec2-52-10-181-145.us-west-2.compute.amazonaws.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(QuestionsApi.class);
    }
}
