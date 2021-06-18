package com.example.prog3.alkasaffollowup;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.ProjectsSpinnerAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Model.ScdualeFollup.SchdualeFollowUp;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SchdualeFollUpActivity extends AppCompatActivity {

    private Spinner projectsspinner;
    private Integer sn;
    private String guid;
    private TextView txtprojref,txtcontdate,txtconstexpdate,txtdocrecdate,txtdownrecdate,txtprogstartdate,txtplaneddate,txtactfindate,txtdeviation;
    private String projRef;
    private ProgressBar mProgressBar;
    private CardView cview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schduale_foll_up);

        guid = getIntent().getExtras().getString("guid");

        mProgressBar=findViewById(R.id.progress_bar);

        txtprojref= findViewById(R.id.txtprojref);
        txtcontdate= findViewById(R.id.txtcontdate);
        txtconstexpdate= findViewById(R.id.txtconstexpdate);
        txtdocrecdate= findViewById(R.id.txtsocrecdate);
        txtdownrecdate= findViewById(R.id.txtdownrecdate);
        txtprogstartdate= findViewById(R.id.txtprogstartdate);
        txtplaneddate= findViewById(R.id.txtplaneddate);
        txtactfindate= findViewById(R.id.txtactfindate);
        txtdeviation= findViewById(R.id.txtdeviation);

        cview=findViewById(R.id.cview);


        projectsspinner=findViewById(R.id.projectsspinner);

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
                Toast.makeText(SchdualeFollUpActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewAllPersons(final List<Project> projects) {
        ProjectsSpinnerAdapter adp=new ProjectsSpinnerAdapter(SchdualeFollUpActivity.this,projects);

        projectsspinner.setAdapter(adp);


        projectsspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String country=   projectsspinner.getItemAtPosition(projectsspinner.getSelectedItemPosition()).toString();
                //Toast.makeText(getApplicationContext(),country,Toast.LENGTH_LONG).show();

                Project project = projects.get(position);
                sn = project.getSn();

                try{
                projRef = project.getProjRef();}
                catch (Exception e){
                    projRef="";
                }

                //Toast.makeText(ContractingInfoActivity.this,Id.toString(),Toast.LENGTH_LONG).show();


                    getAllScdualeFollowUp();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }

    private void getAllScdualeFollowUp() {
        String url= UrlPath.path;
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<SchdualeFollowUp>> schdualeFollowup = projectsInterface.getSchdualeFollowup(sn, guid);

        schdualeFollowup.enqueue(new Callback<List<SchdualeFollowUp>>() {
            @Override
            public void onResponse(Call<List<SchdualeFollowUp>> call, Response<List<SchdualeFollowUp>> response) {
                List<SchdualeFollowUp> schdualeFollowUps = response.body();
                viewAllScdualeFollowUps(schdualeFollowUps);
            }

            @Override
            public void onFailure(Call<List<SchdualeFollowUp>> call, Throwable t) {
                Toast.makeText(SchdualeFollUpActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void viewAllScdualeFollowUps(List<SchdualeFollowUp> schdualeFollowUps) {

        try {

        SchdualeFollowUp schdualeFollowUp = schdualeFollowUps.get(0);

            String s =schdualeFollowUp.getContractDate();
            StringTokenizer tokenizer = new StringTokenizer(s, "T");
            String contdate = tokenizer.nextToken();

            String s1 =schdualeFollowUp.getContExpctdDate();
            StringTokenizer tokenizer2 = new StringTokenizer(s1, "T");
            String constexpdate = tokenizer2.nextToken();

            String s2 =schdualeFollowUp.getDocumentRecvDate();
            StringTokenizer tokenizer3 = new StringTokenizer(s2, "T");
            String docrecdate = tokenizer3.nextToken();

            String s3 =schdualeFollowUp.getDownRecvDate();
            StringTokenizer tokenizer4 = new StringTokenizer(s3, "T");
            String downrecdate = tokenizer4.nextToken();

            String s4 =schdualeFollowUp.getProgstartDate();
            StringTokenizer tokenizer5 = new StringTokenizer(s4, "T");
            String progstartdate = tokenizer5.nextToken();

            String s5 =schdualeFollowUp.getPlanedDate();
            StringTokenizer tokenizer6 = new StringTokenizer(s5, "T");
            String planeddate = tokenizer6.nextToken();

            String s6 =schdualeFollowUp.getActualFinishDate();
            StringTokenizer tokenizer7 = new StringTokenizer(s6, "T");
            String actfindate = tokenizer7.nextToken();


        txtprojref.setText(projRef);
        txtcontdate.setText(contdate);
        txtconstexpdate.setText(constexpdate);
        txtdocrecdate.setText(docrecdate);
        txtdownrecdate.setText(downrecdate);
        txtprogstartdate.setText(progstartdate);
        txtplaneddate.setText(planeddate);
        txtactfindate.setText(actfindate);
        txtdeviation.setText(schdualeFollowUp.getDevDays().toString());

        }catch (Exception e){
            txtprojref.setText("");
            txtcontdate.setText("");
            txtconstexpdate.setText("");
            txtdocrecdate.setText("");
            txtdownrecdate.setText("");
            txtprogstartdate.setText("");
            txtplaneddate.setText("");
            txtactfindate.setText("");
            txtdeviation.setText("");

            Toast.makeText(SchdualeFollUpActivity.this,"There Is No Schduale For This Project!",Toast.LENGTH_LONG).show();
        }

        cview.setVisibility(View.VISIBLE);
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
