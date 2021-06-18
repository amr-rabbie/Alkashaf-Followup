package com.example.prog3.alkasaffollowup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.ClientsMainGridAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ContractInfoGridAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ProjectsSpinnerAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ClientsScreens;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class ContractingInfoActivity extends AppCompatActivity {

    private Spinner projectsspinner;
    private List<Project> projects;
    private GridView grid;
    private SharedPreferences sharedpreferences;
    private Integer sn;
    private String guid;
    private ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contracting_info);

        projectsspinner=findViewById(R.id.projectsspinner);

        sharedpreferences = getSharedPreferences("mypref", MODE_PRIVATE);



            guid = getIntent().getExtras().getString("guid");


        mProgressBar=findViewById(R.id.progress_bar);


        grid = findViewById(R.id.grid);



        if(isNetworkAvailable()){
            //Toast.makeText(this,"Internet Exists!",Toast.LENGTH_LONG).show();


            fetchAllProjects(guid);


            /*
            SharedPreferences.Editor prefsEditor = sharedpreferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(projects);
            prefsEditor.putString("projlist", json);
            prefsEditor.commit();
            */


        }else{
            //Toast.makeText(this,"Internet Not Exists!",Toast.LENGTH_LONG).show();

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





        ContractInfoGridAdapter adp = new ContractInfoGridAdapter(this, viewAllContractInformatios());

        grid.setAdapter(adp);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClientsScreens c = (ClientsScreens) parent.getItemAtPosition(position);

                switch (c.getName()){
                    case "Contracts":
                        Intent i=new Intent(ContractingInfoActivity.this,ProjectContractingInfo.class);
                        i.putExtra("guid",guid);
                        i.putExtra("sn",sn);
                        startActivity(i);
                        break;

                    case "Schedule & Fees":
                        Intent i2=new Intent(ContractingInfoActivity.this,ProjectScduleFees.class);
                        i2.putExtra("guid",guid);
                        i2.putExtra("sn",sn);
                        startActivity(i2);
                        break;

                    case "Design Payment":
                        Intent i3=new Intent(ContractingInfoActivity.this,ProjDesignPayments.class);
                        i3.putExtra("guid",guid);
                        i3.putExtra("sn",sn);
                        startActivity(i3);
                        break;

                    case "Conditions":
                        Intent i4=new Intent(ContractingInfoActivity.this,ProjConditions.class);
                        i4.putExtra("guid",guid);
                        i4.putExtra("sn",sn);
                        startActivity(i4);
                        break;



                }


            }
        });

    }

    private List<Project> addProjectsTolist() {
        List<Project> projectslist=new ArrayList<>();

        for(int i=0;i<projects.size();i++){
            Project project = projects.get(i);
            String projName = project.getProjName();
            String projRef = project.getProjRef();
            Integer sn = project.getSn();

            projectslist.add(new Project(sn,projName,projRef));
        }

        return projectslist;
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
                try{
                List<Project> projects = response.body();
                viewAllPersons(projects);
                }catch (Exception e){
                    Toast.makeText(ContractingInfoActivity.this,"Guid Expired!,Login Agian",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(ContractingInfoActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewAllPersons(final List<Project> projects) {
        ProjectsSpinnerAdapter adp=new ProjectsSpinnerAdapter(ContractingInfoActivity.this,projects);

        projectsspinner.setAdapter(adp);

        //addProjectsTolist();


        projectsspinner.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);


        projectsspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String country=   projectsspinner.getItemAtPosition(projectsspinner.getSelectedItemPosition()).toString();
                //Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();

                Project project = projects.get(position);
                sn = project.getSn();

                //Toast.makeText(ContractingInfoActivity.this,Id.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public List<ClientsScreens> viewAllContractInformatios() {
        List<ClientsScreens> screens = new ArrayList<>();

        screens.add(new ClientsScreens(R.drawable.cont, "Contracts"));
        screens.add(new ClientsScreens(R.drawable.schdule, "Schedule & Fees"));
        screens.add(new ClientsScreens(R.drawable.desfees, "Design Payment"));
        screens.add(new ClientsScreens(R.drawable.cond, "Conditions"));


        return screens;
    }



    /*
    public  boolean isNetworkAvailable(Context con) {
        try{
            connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
            wifiInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            mobileInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


            if(wifiInfo.isConnected() || mobileInfo.isConnected())
            {
                return true;
            }


        }
        catch(Exception e){
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
        }

        return false;
    }
    */

    /*
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public boolean isinternetexists() {
        ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean b=false;
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                //answer="You are connected to a WiFi Network";
                b=true;
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                //answer="You are connected to a Mobile Network";
                b=true;
        } else {
            //answer = "No internet Connectivity";
            b=false;
        }

        return b;

    }
    */

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

/*
    public void chkint(View v){
        if(isNetworkAvailable() ){
            Toast.makeText(ContractingInfoActivity.this,"connected!",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(ContractingInfoActivity.this,"not connected!",Toast.LENGTH_LONG).show();
        }
    }
*/

}


