package com.example.kerem.twitterproject.Contract;

import com.example.kerem.twitterproject.model.TwitterData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MainActivityContract {

    interface View{
        void TwitterView(TwitterData twitter);
        void TwitterAPIError(String errorMsg);
        void EmptyValues();
        void UnknownValue();
    }


    interface API{
        @GET("tweets.json?")
        Call<TwitterData> twitter(
                @Query("q") String query

        );

    }
}
