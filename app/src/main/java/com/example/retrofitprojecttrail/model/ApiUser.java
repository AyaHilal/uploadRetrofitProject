package com.example.retrofitprojecttrail.model;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Aya on 05/04/2018.
 */
//this class give me instance of retrofit

public class ApiUser {
    public static final String BASE_URL="https://simplifiedcoding.net/demos/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient()
    {
        if(retrofit==null)
        {
           // Log.i("hello","retrofit is null");
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create()).build();
          //  Log.i("hello",retrofit.toString());

        }
        return retrofit;
    }
}
