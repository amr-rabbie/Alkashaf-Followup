package com.example.prog3.alkasaffollowup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Data.UrlPath;
import com.example.prog3.alkasaffollowup.Model.ClientUP;
import com.example.prog3.alkasaffollowup.Services.ClientsLoginInterface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {

    EditText etxtun,etxtpw;
    CheckBox chkrem;
    private int clientId;
    private int employeeId;
    private int id;
    private SharedPreferences prefs;
    private String body;
    private SharedPreferences sharedpreferences;
    private String guid;
    private String un;
    private String pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtun=findViewById(R.id.etxtun);
        etxtpw=findViewById(R.id.etxtpw);

        chkrem=findViewById(R.id.chkrem);

        sharedpreferences = getSharedPreferences("mypref", MODE_PRIVATE);


        guid = sharedpreferences.getString("guid", "");



        un = sharedpreferences.getString("un", "");

        pw = sharedpreferences.getString("pw", "");


        etxtun.setText(un);
        etxtpw.setText(pw);

        if(! guid.isEmpty()){
            /*
            Toast.makeText(this,guid,Toast.LENGTH_LONG).show();
            Toast.makeText(this,un,Toast.LENGTH_LONG).show();
            Toast.makeText(this,pw,Toast.LENGTH_LONG).show();
            */

            Intent i=new Intent(MainActivity.this,MainClientsActivity.class);
            i.putExtra("guid",guid);
            i.putExtra("un",un);
            i.putExtra("pw",pw);
            startActivity(i);

        }


        //String guid=sharedpreferences.getString("guid","");

        //Toast.makeText(this,guid,Toast.LENGTH_LONG).show();

        String chk=sharedpreferences.getString("isc","unchk");

        if(chk == "chk"){
            chkrem.isChecked();
        }else{

        }

        if(chkrem.isChecked()){
            String uname=sharedpreferences.getString("un","");
            String upw=sharedpreferences.getString("pw","");

            etxtun.setText(uname);
            etxtpw.setText(upw);
        }

    }

    @Override
    protected void onRestart() {
        if(! guid.isEmpty()){
            /*
            Toast.makeText(this,guid,Toast.LENGTH_LONG).show();
            Toast.makeText(this,un,Toast.LENGTH_LONG).show();
            Toast.makeText(this,pw,Toast.LENGTH_LONG).show();
            */

            Intent i=new Intent(MainActivity.this,MainClientsActivity.class);
            i.putExtra("guid",guid);
            i.putExtra("un",un);
            i.putExtra("pw",pw);
            startActivity(i);

        }
        super.onRestart();
    }

    public void loginaction(View v){

        final String un=etxtun.getText().toString();
        final String pw=etxtpw.getText().toString();

        if(un.isEmpty()){
            Toast.makeText(MainActivity.this,"Must Enter Username",Toast.LENGTH_LONG).show();
        }else if(pw.isEmpty()){
            Toast.makeText(MainActivity.this,"Must Enter Password",Toast.LENGTH_LONG).show();
        }else {



                String path = UrlPath.path;

                Retrofit.Builder builder = new Retrofit.Builder();
                builder.baseUrl(path).addConverterFactory(GsonConverterFactory.create());
                Retrofit retrofit = builder.build();
                ClientsLoginInterface clientsLoginInterface = retrofit.create(ClientsLoginInterface.class);

                Call<Object> objectCall = clientsLoginInterface.clientLogin(un, pw);

                objectCall.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {


                        body = (String) response.body();





                       // Log.i("s", body);


                        if (body != null) {

                            //Toast.makeText(MainActivity.this,body,Toast.LENGTH_LONG).show();


                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("guid", body);
                            editor.putString("un", un);
                            editor.putString("pw", pw);
                            if (chkrem.isChecked()) {
                                editor.putString("isc", "chk");
                            } else {
                                editor.putString("isc", "unchk");
                            }
                            editor.commit();


                            Intent i = new Intent(MainActivity.this, MainClientsActivity.class);
                            i.putExtra("guid", body.toString());
                            i.putExtra("un", un);
                            i.putExtra("pw", pw);
                            if (chkrem.isChecked()) {
                                i.putExtra("isc", "chk");
                            } else {
                                i.putExtra("isc", "unchk");
                            }
                            startActivity(i);


                        } else {
                            Toast.makeText(MainActivity.this, "Invalid Username Or Password!", Toast.LENGTH_LONG).show();
                        }


                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Log.i("exp", t.getMessage());
                        Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_LONG).show();

                    }
                });




        }


    }


}
