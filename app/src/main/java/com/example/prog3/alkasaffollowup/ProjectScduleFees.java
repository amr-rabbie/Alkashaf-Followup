package com.example.prog3.alkasaffollowup;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.ClientsMainGridAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ScdualeFeesAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ClientsScreens;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Model.ProjectFee;
import com.example.prog3.alkasaffollowup.Model.ProjectScdule;
import com.example.prog3.alkasaffollowup.Model.SchFees;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.text.DateFormat;
import java.text.FieldPosition;

import java.text.ParseException;

import java.text.ParsePosition;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectScduleFees extends AppCompatActivity {

    private ListView schfeeslist;
    private TextView txtcontdate,txtexpdate;
    private String guid;
    private int sn;
    private Date date1,date2;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_scdule_fees);

        schfeeslist=findViewById(R.id.scdualefeeslist);

        mProgressBar=findViewById(R.id.progress_bar);

        txtcontdate=findViewById(R.id.txtcontdate);
        txtexpdate=findViewById(R.id.txtexpdate);

        guid = getIntent().getExtras().getString("guid");
        sn = getIntent().getExtras().getInt("sn");

        /*
        ScdualeFeesAdapter adp = new ScdualeFeesAdapter(this, getallClientsActivity());

        schfeeslist.setAdapter(adp);
        */

        getProjectScdule();

        getProjectFees();




        schfeeslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                ClientsScreens c = (ClientsScreens) parent.getItemAtPosition(position);

                switch (c.getName()){
                    case "Contracting Information":
                        Intent i=new Intent(MainClientsActivity.this,ContractingInfoActivity.class);
                        startActivity(i);
                        break;

                    case "Requirements Followup":
                        Intent i2=new Intent(MainClientsActivity.this,ContractingInfoActivity.class);
                        startActivity(i2);
                        break;

                    case "Schedule Followup":
                        Intent i3=new Intent(MainClientsActivity.this,ContractingInfoActivity.class);
                        startActivity(i3);
                        break;

                    case "Permits Followup":
                        Intent i4=new Intent(MainClientsActivity.this,ContractingInfoActivity.class);
                        startActivity(i4);
                        break;

                    case "Financial Followup":
                        Intent i5=new Intent(MainClientsActivity.this,ContractingInfoActivity.class);
                        startActivity(i5);
                        break;

                    case "Mailing Followup":
                        Intent i6=new Intent(MainClientsActivity.this,ContractingInfoActivity.class);
                        startActivity(i6);
                        break;


                }
                */


            }
        });

    }

    private void getProjectFees() {
        String url= UrlPath.path;

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee>> contractInfo = projectsInterface.getProjectfees(sn, guid);
        contractInfo.enqueue(new Callback<List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee>>() {
            @Override
            public void onResponse(Call<List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee>> call, Response<List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee>> response) {
                List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee> projectFees = response.body();


                viewProjectFees(projectFees);
            }

            @Override
            public void onFailure(Call<List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee>> call, Throwable t) {
                Toast.makeText(ProjectScduleFees.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewProjectFees(List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee> projectFees) {
        ScdualeFeesAdapter adp = new ScdualeFeesAdapter(this, projectFees);

        schfeeslist.setAdapter(adp);

        schfeeslist.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
    }

    private void getProjectScdule() {
        String url= UrlPath.path;

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<ProjectScdule>> contractInfo = projectsInterface.getProjectScdule(sn, guid);
        contractInfo.enqueue(new Callback<List<ProjectScdule>>() {
            @Override
            public void onResponse(Call<List<ProjectScdule>> call, Response<List<ProjectScdule>> response) {
                List<ProjectScdule> projectScdules = response.body();
                ProjectScdule projectScdule = projectScdules.get(0);

                try {
                    filltxtctrs( projectScdule);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<ProjectScdule>> call, Throwable t) {
                Toast.makeText(ProjectScduleFees.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }




    private void filltxtctrs(ProjectScdule projectScdule) throws ParseException {

        String s =projectScdule.getContractDate();
        StringTokenizer tokenizer = new StringTokenizer(s, "T");
        String contdate = tokenizer.nextToken();

        String s1 =projectScdule.getContExpctdDate();
        StringTokenizer tokenizer2 = new StringTokenizer(s1, "T");
        String expdate = tokenizer2.nextToken();

        //Toast.makeText(ProjectScduleFees.this,contdate,Toast.LENGTH_LONG).show();

        txtcontdate.setText(contdate);
        txtexpdate.setText(expdate);


    }

    public List<SchFees> getallClientsActivity() {
        List<SchFees> screens = new ArrayList<>();

        screens.add(new SchFees("Design", "56000.00","1/2/2016 12:00:00 AM","8/15/2016 12:00:00 AM"));
        screens.add(new SchFees("Supervision", "26800.00","",""));
        screens.add(new SchFees("Execution", "88800.00","",""));
        screens.add(new SchFees("Finish", "44800.00","",""));

        return screens;
    }


}