package com.example.prog3.alkasaffollowup;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.DesignPaymentsAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ProjectsSpinnerAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ReqirmentsFollUpAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.DesPay;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Model.Req.Requirment;
import com.example.prog3.alkasaffollowup.Model.ReqFolUp;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReqirmentsFollUpActivity extends AppCompatActivity {

    private Spinner projectsspinner;
    private ListView reqirmentfolluplist;

    private Integer sn;
    private String guid;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reqirments_foll_up);

        guid = getIntent().getExtras().getString("guid");

        projectsspinner=findViewById(R.id.projectsspinner);

        mProgressBar=findViewById(R.id.progress_bar);


        if(isNetworkAvailable()){
           // Toast.makeText(this,"Internet Exists!",Toast.LENGTH_LONG).show();


            fetchAllProjects(guid);

            /*
            SharedPreferences.Editor prefsEditor = sharedpreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(projects);
            prefsEditor.putString("projlist", json);
            prefsEditor.commit();
            */


        }else{
           // Toast.makeText(this,"Internet Not Exists!",Toast.LENGTH_LONG).show();

            /*
            Gson gson = new Gson();
            String json = sharedpreferences.getString("projlist", "");
            List<Project> projs = Collections.singletonList(gson.fromJson(json, Project.class));

            viewAllPersons(projs);
            */


            //List<Project> projects = getIntent().getExtras().getParcelable("projects");

            // ArrayList<String> myList = (ArrayList<String>) getIntent().getSerializableExtra("projects");

            List<Project> projects = (List<Project>) getIntent().getSerializableExtra("projects");

            /*
            for(int i=0;i<projects.size();i++){
                Project project = projects.get(i);
                String projName = project.getProjName();
                String projRef = project.getProjRef();
                Integer sn = project.getSn();
                Toast.makeText(ContractingInfoActivity.this,projName+"-"+projRef+"-"+sn,Toast.LENGTH_LONG).show();

            }
            */

            viewAllPersons(projects);



        }






        reqirmentfolluplist=findViewById(R.id.reqirmentfolluplist);







    }

    public List<ReqFolUp> getallClientsActivity() {
        List<ReqFolUp> screens = new ArrayList<>();

        screens.add(new ReqFolUp("GAP at Doha Festival City ","2016/06/063/1723/12/02 ","Commercial Registration.","Commercial Permit ","","Collected "," 4/1/2017 12:00:00 AM ","","2017-04-01"));
        screens.add(new ReqFolUp("GAP at Doha Festival City ","2016/06/063/1723/12/02 ","Photo of the building ","Commercial Permit ","","Collected ","4/1/2017 12:00:00 AM","","2017-04-01"));
        screens.add(new ReqFolUp("GAP at Doha Festival City ","2016/06/063/1723/12/02 ","Copy of original of Ownership Document (OD) last ","Commercial Permit ","","Collected "," 4/1/2017 12:00:00 AM ","","2017-04-01"));
        screens.add(new ReqFolUp("GAP at Doha Festival City ","2016/06/063/1723/12/02 ","Copy of original of Ownership Document (OD) last ","Commercial Permit ","","Collected "," 4/1/2017 12:00:00 AM ","","2017-04-01"));


        return screens;
    }

    private void fetchAllProjects(String guid) {
        String url= UrlPath.path;
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<Project>> allProjectsByClient = projectsInterface.getAllProjectsByClient(guid);

        allProjectsByClient.enqueue(new Callback<List<Project>>() {
            @Override
            public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                List<Project> projects = response.body();
                viewAllPersons(projects);
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(ReqirmentsFollUpActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewAllPersons(final List<Project> projects) {
        ProjectsSpinnerAdapter adp=new ProjectsSpinnerAdapter(ReqirmentsFollUpActivity.this,projects);

        projectsspinner.setAdapter(adp);




        projectsspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String country=   projectsspinner.getItemAtPosition(projectsspinner.getSelectedItemPosition()).toString();
                //Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();

                Project project = projects.get(position);
                sn = project.getSn();

                //Toast.makeText(ContractingInfoActivity.this,Id.toString(),Toast.LENGTH_LONG).show();

                getAllRequirments();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }




    private void getAllRequirments() {
        String url= UrlPath.path;
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<Requirment>> projectRequirement = projectsInterface.getProjectRequirement(sn, guid);

        projectRequirement.enqueue(new Callback<List<Requirment>>() {
            @Override
            public void onResponse(Call<List<Requirment>> call, Response<List<Requirment>> response) {
                List<Requirment> requirments = response.body();
                viewAllRequirements(requirments);
            }

            @Override
            public void onFailure(Call<List<Requirment>> call, Throwable t) {
                Toast.makeText(ReqirmentsFollUpActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewAllRequirements(List<Requirment> requirments) {
        ReqirmentsFollUpAdapter adp = new ReqirmentsFollUpAdapter(ReqirmentsFollUpActivity.this, requirments);

        reqirmentfolluplist.setAdapter(adp);

        reqirmentfolluplist.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    public   boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean b;
        if(activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            b=true;
        }else {
            b=false;
        }
        return b;
    }


}
