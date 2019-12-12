package com.example.kerem.twitterproject.service;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TwitterClient {

    private static String url = "https://api.twitter.com/1.1/search/";
    private static String token = "AAAAAAAAAAAAAAAAAAAAACCT%2FQAAAAAANSJTHe58puqpCL4%2Fh%2F" +
            "pZHqGCxcI%3DZtbKViWssX8nNlgfOI1LfK2BVZU9CjjjJMqus0hPxpha5gDiAX";


    public static Retrofit retrofitService() {

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .addHeader("Authorization","Bearer "+token)
                        .build();
                return chain.proceed(request);
            }
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

}