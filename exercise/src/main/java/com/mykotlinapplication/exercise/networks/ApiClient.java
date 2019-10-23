package com.mykotlinapplication.exercise.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private String baseUrl = "https://jsonplaceholder.typicode.com";
    public Retrofit retrofit;

    public Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl).build();
        }
        return retrofit;
    }
}
