package com.example.retrofitakmaralabdylmanapkyzyakmaralain_2_20.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    public RetrofitBuilder() {
    }

    private static DoApi instance;

    public static DoApi getInstance() {
        if (instance == null){
            instance = init();
        }
        return instance;
    }

    public static DoApi init() {
        return new Retrofit
                .Builder()
                .baseUrl("https://www.boredapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DoApi.class);
    }

}
