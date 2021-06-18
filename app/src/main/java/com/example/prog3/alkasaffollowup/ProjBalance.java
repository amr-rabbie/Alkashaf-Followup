package com.example.prog3.alkasaffollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.BalancesRecyclerAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ProjBal.ProjectBalance;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjBalance extends AppCompatActivity {

    private RecyclerView balancerecycler;
    private String guid;
    private int sn;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_balance);

        guid = getIntent().getExtras().getString("guid");
        sn = getIntent().getExtras().getInt("sn");

        balancerecycler=findViewById(R.id.balancerecycler);
        mProgressBar=findViewById(R.id.progress_bar);


        LinearLayoutManager lmgr=new LinearLayoutManager(this);

        balancerecycler.setLayoutManager(lmgr);

        getAllProjectBalance();
    }

    private void getAllProjectBalance() {
        String url= UrlPath.path;
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<ProjectBalance>> projectBalance = projectsInterface.getProjectBalance(sn, guid);
        projectBalance.enqueue(new Callback<List<ProjectBalance>>() {
            @Override
            public void onResponse(Call<List<ProjectBalance>> call, Response<List<ProjectBalance>> response) {
                List<ProjectBalance> balances = response.body();
                viewAllProjectBalances(balances);
            }

            @Override
            public void onFailure(Call<List<ProjectBalance>> call, Throwable t) {
                Toast.makeText(ProjBalance.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void viewAllProjectBalances(List<ProjectBalance> balances) {
        BalancesRecyclerAdapter adapter=new BalancesRecyclerAdapter(ProjBalance.this,balances);
        balancerecycler.setAdapter(adapter);

        balancerecycler.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }
}
