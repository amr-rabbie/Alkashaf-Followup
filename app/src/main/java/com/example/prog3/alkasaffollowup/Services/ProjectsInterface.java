package com.example.prog3.alkasaffollowup.Services;

import com.example.prog3.alkasaffollowup.Model.DesignPayement;
import com.example.prog3.alkasaffollowup.Model.Perm.PermitFollowup;
import com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage;
import com.example.prog3.alkasaffollowup.Model.ProjBal.ProjectBalance;
import com.example.prog3.alkasaffollowup.Model.ProjColl.ProjectCollected;
import com.example.prog3.alkasaffollowup.Model.ProjInvoi.ProjectInvoice;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Model.ProjectCondition;
import com.example.prog3.alkasaffollowup.Model.ProjectFee;
import com.example.prog3.alkasaffollowup.Model.ProjectInfo.ProjectInfo;
import com.example.prog3.alkasaffollowup.Model.ProjectScdule;
import com.example.prog3.alkasaffollowup.Model.Req.Requirment;
import com.example.prog3.alkasaffollowup.Model.ScdualeFollup.SchdualeFollowUp;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by prog3 on 3/11/2018.
 */

public interface ProjectsInterface {





    @GET("Projects/MyProjects")
    public Call<List<Project>> getAllProjectsByClient(

            @Query("USER_KEY") String keyid
    );

    @POST("ClientContractingInfo/SearchInfo")
    public Call<List<ProjectInfo>> getProjectContractInfo(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ClientContractingInfo/ProjectSchedule")
    public Call<List<ProjectScdule>> getProjectScdule(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ClientContractingInfo/ProjectFees")
    public Call<List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee>> getProjectfees(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ClientContractingInfo/PaymentDesign")
    public Call<List<com.example.prog3.alkasaffollowup.Model.DesignPay.DesignPayement>> getDesignPayment(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ClientContractingInfo/Conditions")
    public Call<List<ProjectCondition>> getProjectConditions(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ClientRequirements/Search")
    public Call<List<Requirment>> getProjectRequirement(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ClientDesignFoll/Search")
    public Call<List<SchdualeFollowUp>> getSchdualeFollowup(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ClientPermitsFoll/Searchresult")
    public Call<List<PermitFollowup>> getPermitsFollowup(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ProgressStage/Search")
    public Call<List<ProgressSteage>> getProjectProgressSteage(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("InvoiceDesign/Search")
    public Call<List<ProjectInvoice>> getProjectInvoices(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );


    @POST("CollectedDesign/Search")
    public Call<List<ProjectCollected>> getProjectCollected(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );

    @POST("ProjectBalanceDesign/Search")
    public Call<List<ProjectBalance>> getProjectBalance(
            @Query("sn") int sn,
            @Query("USER_KEY") String keyid


    );




}
