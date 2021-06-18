package com.example.prog3.alkasaffollowup.network;

import com.example.prog3.alkasaffollowup.Data.UrlPath;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by prog5 on 3/26/2018.
 */

public class RetrofitInstance {

    public static Retrofit retrofit;
    public static String url= UrlPath.path;

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
