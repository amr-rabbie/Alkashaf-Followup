package com.example.prog3.alkasaffollowup.Services;

import com.example.prog3.alkasaffollowup.Model.ClientUP;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by prog3 on 3/11/2018.
 */

public interface ClientsLoginInterface {


/*
    @FormUrlEncoded
    @POST("LoginData/Login")
    public Call<ClientUP> clientLogin(
            @Field("uid") String un,
            @Field("pwd") String pw)
    ;
*/

    @FormUrlEncoded
    @POST("LoginData/Login")
    public Call<Object> clientLogin(
            @Field("uid") String un,
            @Field("pwd") String pw)
            ;

    @GET("LoginData/LogOut")
    public Call<Object> Logout(

            @Query("USER_KEY") String keyid
    );

}

