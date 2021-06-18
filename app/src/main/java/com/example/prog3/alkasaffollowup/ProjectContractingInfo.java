package com.example.prog3.alkasaffollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Model.ProjectInfo.ProjStatusList;
import com.example.prog3.alkasaffollowup.Model.ProjectInfo.ProjTypesList;
import com.example.prog3.alkasaffollowup.Model.ProjectInfo.ProjWorkscopeList;
import com.example.prog3.alkasaffollowup.Model.ProjectInfo.ProjectInfo;
import com.example.prog3.alkasaffollowup.Model.ProjectInfo.QatCitiesList;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectContractingInfo extends AppCompatActivity {

    TextView txtpname,txtpref,txtscope,txtbname,txtloc,txtarea,txttype,txtwscope;
    private String guid;
    private int sn;
    private CardView cview;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_contracting_info);


        guid = getIntent().getExtras().getString("guid");
        sn = getIntent().getExtras().getInt("sn");

        txtpname=findViewById(R.id.txtpname);
        txtpref=findViewById(R.id.txtpref);
        txtscope=findViewById(R.id.txtscope);
        txtbname=findViewById(R.id.txtbname);
        txtloc=findViewById(R.id.txtloc);
        txtarea=findViewById(R.id.txtarea);
        txttype=findViewById(R.id.txttype);
        txtwscope=findViewById(R.id.txtwscope);

        cview=findViewById(R.id.cview);

        mProgressBar=findViewById(R.id.progress_bar);

        filldata();
    }

    private void filldata() {
        String url= UrlPath.path;

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<ProjectInfo>> contractInfo = projectsInterface.getProjectContractInfo(sn, guid);
        contractInfo.enqueue(new Callback<List<ProjectInfo>>() {
            @Override
            public void onResponse(Call<List<ProjectInfo>> call, Response<List<ProjectInfo>> response) {
                List<ProjectInfo> projects = response.body();
                ProjectInfo projectInfo = projects.get(0);

                fillctrs( projectInfo);
            }

            @Override
            public void onFailure(Call<List<ProjectInfo>> call, Throwable t) {
                Toast.makeText(ProjectContractingInfo.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }

    private void fillctrs(ProjectInfo projectInfo) {
        txtpname.setText(projectInfo.getProjName());
        txtpref.setText(projectInfo.getProjRef());
        txtbname.setText(projectInfo.getBuildingName());
        txtarea.setText(projectInfo.getProjArea());

        ProjTypesList projTypesList = projectInfo.getProjTypesList();
        String typename = projTypesList.getName();

        ProjWorkscopeList projWorkscopeList = projectInfo.getProjWorkscopeList();
        String workscopename = projWorkscopeList.getName();

        QatCitiesList location =projectInfo.getQatCitiesList();



        txtloc.setText(location.getName());

        txtwscope.setText(projectInfo.getDiscplnsList());
        txttype.setText(typename);
        txtscope.setText(workscopename);

        cview.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);



    }


}
