package com.example.prog3.alkasaffollowup.network;



import com.example.prog3.alkasaffollowup.Model.MailingOut;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by prog5 on 3/26/2018.
 */

public interface GetData {

    @POST("ClientMailingFoll/Searchout")
    Call<List<MailingOut>> getData(@Query("USER_KEY") String USER_KEY);
}
