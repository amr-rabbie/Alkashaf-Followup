package com.example.prog3.alkasaffollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.CollectedAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ProjColl.ProjectCollected;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjCollectedFollowup extends AppCompatActivity {

    private ListView collectedlist;
    private String guid;
    int sn;
    private String ref;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_collected_followup);

        guid = getIntent().getExtras().getString("guid");
        sn = getIntent().getExtras().getInt("sn");
        ref = getIntent().getExtras().getString("ref");
        
        
        collectedlist=findViewById(R.id.collectedlist);

        mProgressBar=findViewById(R.id.progress_bar);

        getAllProjectCollected();
    }

    private void getAllProjectCollected() {
        String url= UrlPath.path;
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<ProjectCollected>> projectCollected = projectsInterface.getProjectCollected(sn, guid);
        projectCollected.enqueue(new Callback<List<ProjectCollected>>() {
            @Override
            public void onResponse(Call<List<ProjectCollected>> call, Response<List<ProjectCollected>> response) {
                List<ProjectCollected> collectedList = response.body();
                viewAllProjectCollected(collectedList);
            }

            @Override
            public void onFailure(Call<List<ProjectCollected>> call, Throwable t) {
                Toast.makeText(ProjCollectedFollowup.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewAllProjectCollected(List<ProjectCollected> collectedList) {
        CollectedAdapter adapter=new CollectedAdapter(ProjCollectedFollowup.this,collectedList,ref);
        collectedlist.setAdapter(adapter);

        collectedlist.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }
}
