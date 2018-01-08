package com.cjwilliams24680.questiongenerator.network;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chris on 1/7/18.
 *
 * todo turn this into Kotlin
 */

public interface QuestionsApi {

    @GET Call<JSONObject> getQuestion();
}
