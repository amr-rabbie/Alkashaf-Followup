package com.example.prog3.alkasaffollowup;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.ClientsMainGridAdapter;
import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ClientsScreens;
import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.Services.ClientsLoginInterface;
import com.example.prog3.alkasaffollowup.Services.ProjectsInterface;
import com.example.prog3.alkasaffollowup.SqliTe.Data;
import com.example.prog3.alkasaffollowup.SqliTe.DbUtil;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainClientsActivity extends AppCompatActivity {

    private GridView clientsmaingrid;
    private String guid;
    private String un;
    private MenuItem welitemmenu;
    private SharedPreferences sharedpreferences;
    private String body;
    private List<Project> projects;
    private SQLiteDatabase db;
    private List<Project> projs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clients);


/*
        if(isNetworkAvailable()){
            //Toast.makeText(this,"Internet Exists!",Toast.LENGTH_LONG).show();
        }else{
            //Toast.makeText(this,"Internet Not Exists!",Toast.LENGTH_LONG).show();
            //finish();
        }
        */

        sharedpreferences = getSharedPreferences("mypref", MODE_PRIVATE);

        guid = getIntent().getExtras().getString("guid");

        un= getIntent().getExtras().getString("un");

        Toast.makeText(this,"Welcome " + un,Toast.LENGTH_LONG).show();

        clientsmaingrid = findViewById(R.id.clientsmaingrid);

        welitemmenu=findViewById(R.id.wel);

        connecttodb();


        if(isNetworkAvailable()){
            Toast.makeText(this,"Internet Exists!",Toast.LENGTH_LONG).show();


            //fetchAllProjects(guid);

            String url= UrlPath.path;
            Retrofit.Builder builder=new Retrofit.Builder();
            builder.baseUrl(url).addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            ProjectsInterface projectsInterface = retrofit.create(ProjectsInterface.class);
            Call<List<Project>> allProjectsByClient = projectsInterface.getAllProjectsByClient(guid);

            allProjectsByClient.enqueue(new Callback<List<Project>>() {
                @Override
                public void onResponse(Call<List<Project>> call, Response<List<Project>> response) {
                    projects = response.body();
                    //viewAllPersons(projects);

                    int delete = db.delete(Data.Db_Table, null, null);
                    if(delete > 0) {

                        for (int i = 0; i < projects.size(); i++) {
                            Project project = projects.get(i);
                            String projName = project.getProjName();
                            String projRef = project.getProjRef();
                            String sn = project.getSn().toString();
                            ContentValues values = new ContentValues();
                            values.put(Data.Key_ProjName, projName);
                            values.put(Data.Key_ProjRef, projRef);
                            values.put(Data.Key_Sn, sn);

                            long insert = db.insert(Data.Db_Table, null, values);
                            if (insert > 0) {

                            }

                        }

                    }

                }

                @Override
                public void onFailure(Call<List<Project>> call, Throwable t) {
                    Toast.makeText(MainClientsActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

                }
            });







        }else{
            Toast.makeText(this,"Internet Not Exists!",Toast.LENGTH_LONG).show();

            //projs=getallprojects();

            projs=new ArrayList<>();

            String[] columns={Data.Key_ProjName,Data.Key_ProjRef,Data.Key_Sn};

            Cursor cursor = db.query(Data.Db_Table, columns, null, null, null, null, Data.Key_ProjName);

            if(cursor.moveToFirst()){
                while (cursor.moveToNext()){

                    String proj_name = cursor.getString(cursor.getColumnIndex("proj_name"));
                    String proj_ref = cursor.getString(cursor.getColumnIndex("proj_ref"));
                    int proj_sn = cursor.getInt(cursor.getColumnIndex("proj_sn"));


                    projs.add(new Project(proj_sn,proj_name,proj_ref));

                }
            }



            /*
            for (int i=0;i<projs.size();i++){
                Project project = projs.get(i);
                String projName = project.getProjName();
                String projRef = project.getProjRef();
                Integer sn = project.getSn();
                Toast.makeText(MainClientsActivity.this,projName+" "+projRef+" "+sn,Toast.LENGTH_LONG).show();
            }
            */



            /*
            Gson gson = new Gson();
            String json = sharedpreferences.getString("projlist", "");
            List<Project> projs = Collections.singletonList(gson.fromJson(json, Project.class));

            viewAllPersons(projs);
            */



        }

        ClientsMainGridAdapter adp = new ClientsMainGridAdapter(this, getallClientsActivity());

        clientsmaingrid.setAdapter(adp);


        clientsmaingrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClientsScreens c = (ClientsScreens) parent.getItemAtPosition(position);

                switch (c.getName()){
                    case "Contracts":
                        Intent i=new Intent(MainClientsActivity.this,ContractingInfoActivity.class);
                        i.putExtra("guid",guid);

                        if(isNetworkAvailable() == false) {
                            i.putExtra("projects", (Serializable) projs);
                        }

                        startActivity(i);
                        break;

                    case "Requirements":
                        Intent i2=new Intent(MainClientsActivity.this,ReqirmentsFollUpActivity.class);
                        i2.putExtra("guid",guid);
                        if(isNetworkAvailable() == false) {
                            i2.putExtra("projects", (Serializable) projs);
                        }
                        startActivity(i2);
                        break;

                    case "Schedule":
                        Intent i3=new Intent(MainClientsActivity.this,SchdualeFollUpActivity.class);
                        i3.putExtra("guid",guid);
                        if(isNetworkAvailable() == false) {
                            i3.putExtra("projects", (Serializable) projs);
                        }
                        startActivity(i3);
                        break;

                    case "Permits":
                        Intent i4=new Intent(MainClientsActivity.this,PermitsFollUpActivity.class);
                        i4.putExtra("guid",guid);
                        if(isNetworkAvailable() == false) {
                            i4.putExtra("projects", (Serializable) projs);
                        }
                        startActivity(i4);
                        break;

                    case "Financial":
                        Intent i5=new Intent(MainClientsActivity.this,FinancialFollowupActivity.class);
                        i5.putExtra("guid",guid);
                        if(isNetworkAvailable() == false) {
                            i5.putExtra("projects", (Serializable) projs);
                        }
                        startActivity(i5);
                        break;

                    case "Mailing":
                        Intent i6=new Intent(MainClientsActivity.this,MailingFollowupActivity.class);
                        i6.putExtra("guid",guid);
                        if(isNetworkAvailable() == false) {
                            i6.putExtra("projects", (Serializable) projs);
                        }
                        startActivity(i6);
                        break;

                }


            }
        });

        sharedpreferences = getSharedPreferences("mypref", MODE_PRIVATE);

        String guid=sharedpreferences.getString("guid","");

        //Toast.makeText(this,guid,Toast.LENGTH_LONG).show();

    }

    private void connecttodb() {
        DbUtil util=new DbUtil(this);
        db = util.getWritableDatabase();
    }

    private List<Project> getallprojects() {
        List<Project> projs=new ArrayList<>();

        String[] columns={Data.Key_ProjName,Data.Key_ProjRef,Data.Key_Sn};

        Cursor cursor = db.query(Data.Db_Table, columns, null, null, null, null, Data.Key_ProjName);

        if(cursor.moveToFirst()){
            while (cursor.moveToNext()){

                String proj_name = cursor.getString(cursor.getColumnIndex("proj_name"));
                String proj_ref = cursor.getString(cursor.getColumnIndex("proj_ref"));
                int proj_sn = cursor.getInt(cursor.getColumnIndex("proj_sn"));


                projs.add(new Project(proj_sn,proj_name,proj_ref));

            }
        }

        return projs;
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
                projects = response.body();
                //viewAllPersons(projects);

            }

            @Override
            public void onFailure(Call<List<Project>> call, Throwable t) {
                Toast.makeText(MainClientsActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }

    public List<ClientsScreens> getallClientsActivity() {
        List<ClientsScreens> screens = new ArrayList<>();

        screens.add(new ClientsScreens(R.drawable.contrimg, "Contracts"));
        screens.add(new ClientsScreens(R.drawable.reqimg, "Requirements"));
        screens.add(new ClientsScreens(R.drawable.desimg, "Schedule"));
        screens.add(new ClientsScreens(R.drawable.permimg, "Permits"));
        screens.add(new ClientsScreens(R.drawable.finimg, "Financial"));
        screens.add(new ClientsScreens(R.drawable.mailgimg, "Mailing"));

        return screens;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logoutmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                logout();
                break;
            case R.id.wel: 
                welitemmenu.setTitle("Welcome " + un);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        /*
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("guid", "");
        editor.putString("un", "");
        editor.putString("pw", "");
        editor.commit();
        Intent i=new Intent(MainClientsActivity.this,MainActivity.class);
        startActivity(i);
        */

        String path = UrlPath.path;

        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(path).addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        ClientsLoginInterface clientsLoginInterface = retrofit.create(ClientsLoginInterface.class);

        Call<Object> objectCall = clientsLoginInterface.Logout(guid);

        objectCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {


                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("guid", "");
                editor.putString("un", "");
                editor.putString("pw", "");
                editor.commit();
                Intent i=new Intent(MainClientsActivity.this,MainActivity.class);
                startActivity(i);


            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.i("exp", t.getMessage());
                Toast.makeText(MainClientsActivity.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

    /*
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
}