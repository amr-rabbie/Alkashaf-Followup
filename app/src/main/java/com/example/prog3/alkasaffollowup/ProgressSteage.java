package com.example.prog3.alkasaffollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.example.prog3.alkasaffollowup.Adapters.ProgrssSteageAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ProjectsSpinnerAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ReqirmentsFollUpAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ProgSteg;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Model.ReqFolUp;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProgressSteage extends AppCompatActivity {

    private Spinner projectsspinner;
    private ListView progresssteagelist;
    private Integer sn;
    private String guid;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_steage);

        guid = getIntent().getExtras().getString("guid");
        sn = getIntent().getExtras().getInt("sn");


        //projectsspinner=findViewById(R.id.projectsspinner);

        //fetchAllProjects();


        progresssteagelist=findViewById(R.id.progresssteagelist);

        mProgressBar=findViewById(R.id.progress_bar);

        getProjectProgressSteage();





    }

    public List<ProgSteg> getallClientsActivity() {
        List<ProgSteg> screens = new ArrayList<>();

        screens.add(new ProgSteg("2017/04/063/3635/29/01 ","4/18/2017 12:00:00 AM  ","Design","5/11/2017 12:00:00 AM","Design  ","4/18/2017 12:00:00 AM"));



        return screens;
    }

    private void fetchAllProjects() {

        /*
        String url= UrlPath.path;
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<Project>> allProjects = projectsInterface.getAllProjects();

        allProjects.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                projects = response.body();
                viewAllprojects(projects);
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(ContractingInfoActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
        */

        /*
        List<Project> projects=new ArrayList<>();
        projects.add(new Project("Project 1"));
        projects.add(new Project("Project 2"));
        projects.add(new Project("Project 3"));
        projects.add(new Project("Project 4"));
        projects.add(new Project("Project 5"));
        projects.add(new Project("Project 6"));

        viewAllprojects(projects);
        */

    }

    private void viewAllprojects(final List<Project> projects) {
        ProjectsSpinnerAdapter adp=new ProjectsSpinnerAdapter(ProgressSteage.this,projects);
        projectsspinner.setAdapter(adp);

        projectsspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String country=   projectsspinner.getItemAtPosition(projectsspinner.getSelectedItemPosition()).toString();
                //Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();

                //Project project = projects.get(position);
                //sn = project.getSn();

                //Toast.makeText(ContractingInfoActivity.this,Id.toString(),Toast.LENGTH_LONG).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




/*
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ContractingInfoActivity.this,
                android.R.layout.simple_spinner_item, (String[]) projects.toArray());

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        projectsspinner.setAdapter(dataAdapter);
        */
    }

    private void getProjectProgressSteage() {

        String url= UrlPath.path;

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage>> projectProgressSteage = projectsInterface.getProjectProgressSteage(sn, guid);
        projectProgressSteage.enqueue(new Callback<List<com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage>>() {
            @Override
            public void onResponse(Call<List<com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage>> call, Response<List<com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage>> response) {
                List<com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage> progressSteages = response.body();
                viewAllProgressSteages(progressSteages);

            }

            @Override
            public void onFailure(Call<List<com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage>> call, Throwable t) {

            }
        });


    }

    private void viewAllProgressSteages(List<com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage> progressSteages) {
        ProgrssSteageAdapter adp = new ProgrssSteageAdapter(this, progressSteages);

        progresssteagelist.setAdapter(adp);

        progresssteagelist.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }


}
