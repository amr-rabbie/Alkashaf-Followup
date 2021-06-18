package com.example.prog3.alkasaffollowup.network;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

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

}
