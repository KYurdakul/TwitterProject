package com.example.kerem.twitterproject.presenter;

import com.example.kerem.twitterproject.Contract.MainActivityContract;
import com.example.kerem.twitterproject.model.TwitterData;
import com.example.kerem.twitterproject.service.TwitterClient;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;

public class TwitterPresenter {

    private MainActivityContract.View view;
    public TwitterPresenter(MainActivityContract.View view){
        this.view = view;
    }

    public void getTwitter(String query)
    {
        MainActivityContract.API api = TwitterClient.retrofitService().create(MainActivityContract.API.class);
        Call<TwitterData> call = api.twitter(query);
        call.enqueue(new Callback<TwitterData>() {
            @Override
            public void onResponse(Call<TwitterData> call, Response<TwitterData> response) {
                TwitterData twitter = response.body();

                if(twitter==null){
                    view.EmptyValues();
                }
                else if(twitter!=null) {
                    if(String.valueOf(twitter.getStatuses()).equals("[]")){
                        view.UnknownValue();
                    }
                    else{
                        view.TwitterView(twitter);
                    }
                }

            }

            @Override
            public void onFailure(Call<TwitterData> call, Throwable t) {
                view.TwitterAPIError(t.toString());
            }


        });

    }
}
