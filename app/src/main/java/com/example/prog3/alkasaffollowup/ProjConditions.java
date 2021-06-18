package com.example.prog3.alkasaffollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.DesignPaymentsAdapter;
import com.example.prog3.alkasaffollowup.Adapters.ProjectConditionAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.DesPay;
import com.example.prog3.alkasaffollowup.Model.ProCond;
import com.example.prog3.alkasaffollowup.Model.ProjectCondition;
import com.example.prog3.alkasaffollowup.Model.ProjectFee;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjConditions extends AppCompatActivity {

    private ListView projconditionslist;
    private String guid;
    private int sn;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proj_conditions);

        guid = getIntent().getExtras().getString("guid");
        sn = getIntent().getExtras().getInt("sn");


        projconditionslist = findViewById(R.id.projconditionslist);

        mProgressBar=findViewById(R.id.progress_bar);


        getProjectConditions();





    }

    private void getProjectConditions() {
        String url= UrlPath.path;

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
        Call<List<ProjectCondition>> contractInfo = projectsInterface.getProjectConditions(sn, guid);
        contractInfo.enqueue(new Callback<List<ProjectCondition>>() {
            @Override
            public void onResponse(Call<List<ProjectCondition>> call, Response<List<ProjectCondition>> response) {
                List<ProjectCondition> projectConditions = response.body();


                viewProjectConditions(projectConditions);
            }

            @Override
            public void onFailure(Call<List<ProjectCondition>> call, Throwable t) {
                Toast.makeText(ProjConditions.this,t.getMessage().toString(),Toast.LENGTH_LONG).show();

            }
        });
    }


    private void viewProjectConditions(List<ProjectCondition> projectConditions) {
        ProjectConditionAdapter adp = new ProjectConditionAdapter(this, projectConditions);

        projconditionslist.setAdapter(adp);

        projconditionslist.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);

    }

    public List<ProCond> getallClientsActivity() {
        List<ProCond> screens = new ArrayList<>();

        screens.add(new ProCond("A/m fees excluded any supervision works. "));
        screens.add(new ProCond("The approval for Electrical systems should be the same MV and If any modification done by another tenant for the same MV, In this case landlord shall be responsible for getting approval and not Al Kashaf."));
        screens.add(new ProCond("In case of any changes in electrical load for the shop not similar from the approved load from kahramaa, The mall shall introduce or present the modified load to kahramaa for approval, Subsequently Al Kashaf Consultant will certify (That there is no different in loads) to obtain building permit. "));
        screens.add(new ProCond("Final architecture drawing including section drawings, elevation and reflecting ceiling drawings (Auto Cad drawing) is required. "));
        screens.add(new ProCond("A/m fees excluded any other fees or costs that are not determined in technical offer. "));
        screens.add(new ProCond("A/m fees payments will be due after a week from the submission date. "));
        screens.add(new ProCond("This proposal is valid for one month only from date of offer submission. "));


        return screens;
    }


}