package com.example.prog3.alkasaffollowup;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.ContractInfoGridAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ProjectsSpinnerAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ClientsScreens;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FinancialFollowupActivity extends AppCompatActivity {

    private Spinner projectsspinner;
    GridView grid;
    private Integer sn;
    private String guid;
    private String ref;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_followup);

        guid = getIntent().getExtras().getString("guid");


        projectsspinner=findViewById(R.id.projectsspinner);

        grid = findViewById(R.id.grid);

        mProgressBar=findViewById(R.id.progress_bar);

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






        ContractInfoGridAdapter adp = new ContractInfoGridAdapter(this, viewAllContractInformatios());

        grid.setAdapter(adp);


        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClientsScreens c = (ClientsScreens) parent.getItemAtPosition(position);

                switch (c.getName()){
                    case "Progress Stage":
                        Intent i=new Intent(FinancialFollowupActivity.this,ProgressSteage.class);
                        i.putExtra("guid",guid);
                        i.putExtra("sn",sn);
                        startActivity(i);
                        break;

                    case "Payments and Conditions":
                        Intent i2=new Intent(FinancialFollowupActivity.this,PaymentsAndConditions.class);
                        i2.putExtra("guid",guid);
                        i2.putExtra("sn",sn);
                        startActivity(i2);
                        break;

                    case "Invoices":
                        Intent i3=new Intent(FinancialFollowupActivity.this,ProjInvoicesFollowup.class);
                        i3.putExtra("guid",guid);
                        i3.putExtra("sn",sn);
                        i3.putExtra("ref",ref);
                        startActivity(i3);
                        break;

                    case "Collected":
                        Intent i4=new Intent(FinancialFollowupActivity.this,ProjCollectedFollowup.class);
                        i4.putExtra("guid",guid);
                        i4.putExtra("sn",sn);
                        i4.putExtra("ref",ref);
                        startActivity(i4);
                        break;

                    case "Balance":
                        Intent i5=new Intent(FinancialFollowupActivity.this,ProjBalance.class);
                        i5.putExtra("guid",guid);
                        i5.putExtra("sn",sn);
                        startActivity(i5);
                        break;



                }


            }
        });

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
                Toast.makeText(FinancialFollowupActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewAllPersons(final List<Project> projects) {
        ProjectsSpinnerAdapter adp=new ProjectsSpinnerAdapter(FinancialFollowupActivity.this,projects);

        projectsspinner.setAdapter(adp);

        projectsspinner.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);


        projectsspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String country=   projectsspinner.getItemAtPosition(projectsspinner.getSelectedItemPosition()).toString();
                //Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();

                Project project = projects.get(position);
                sn = project.getSn();

                ref = project.getProjRef();

                //Toast.makeText(ContractingInfoActivity.this,Id.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }


    public List<ClientsScreens> viewAllContractInformatios() {
        List<ClientsScreens> screens = new ArrayList<>();

        screens.add(new ClientsScreens(R.drawable.prog, "Progress Stage"));
        screens.add(new ClientsScreens(R.drawable.pay, "Payments and Conditions"));
        screens.add(new ClientsScreens(R.drawable.invoice, "Invoices"));
        screens.add(new ClientsScreens(R.drawable.col, "Collected"));
        screens.add(new ClientsScreens(R.drawable.bal, "Balance"));

        return screens;
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


