package com.example.prog3.alkasaffollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.InvoicesRecyclerAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ProjInvoi.ProjectInvoice;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjInvoicesFollowup extends AppCompatActivity {

    private RecyclerView invoicesrecycler;
    private String guid;
    private int sn;
    private String ref;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_invoices_followup);

        guid = getIntent().getExtras().getString("guid");
        sn = getIntent().getExtras().getInt("sn");
        ref = getIntent().getExtras().getString("ref");

        invoicesrecycler=findViewById(R.id.invoicesrecycler);

        mProgressBar=findViewById(R.id.progress_bar);

        LinearLayoutManager lmgr=new LinearLayoutManager(this);

        invoicesrecycler.setLayoutManager(lmgr);

        getAllProjectInvoices();
    }

    private void getAllProjectInvoices() {
        String url= UrlPath.path;
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<ProjectInvoice>> projectInvoices = projectsInterface.getProjectInvoices(sn, guid);
        projectInvoices.enqueue(new Callback<List<ProjectInvoice>>() {
            @Override
            public void onResponse(Call<List<ProjectInvoice>> call, Response<List<ProjectInvoice>> response) {
                List<ProjectInvoice> invoices = response.body();
                viewAllProjectInvoices(invoices);
            }

            @Override
            public void onFailure(Call<List<ProjectInvoice>> call, Throwable t) {
                Toast.makeText(ProjInvoicesFollowup.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void viewAllProjectInvoices(List<ProjectInvoice> invoices) {
        InvoicesRecyclerAdapter adapter=new InvoicesRecyclerAdapter(ProjInvoicesFollowup.this,invoices,ref);
        invoicesrecycler.setAdapter(adapter);

        invoicesrecycler.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }
}
