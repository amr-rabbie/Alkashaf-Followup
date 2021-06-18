package com.example.prog3.alkasaffollowup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Adapters.MailingOutAdapter;
import com.example.prog3.alkasaffollowup.Model.MailingOut;
import com.example.prog3.alkasaffollowup.clicklistener.ClickListener;
import com.example.prog3.alkasaffollowup.clicklistener.RecyclerTouchListener;
import com.example.prog3.alkasaffollowup.network.GetData;
import com.example.prog3.alkasaffollowup.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MailingFollowupActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MailingOutAdapter mailingOutAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mailing_followup);

        String s = getIntent().getExtras().getString("guid");

        GetData getData = RetrofitInstance.getRetrofitInstance().create(GetData.class);

        mProgressBar=findViewById(R.id.progress_bar);

        Call<List<MailingOut>> connection = getData.getData(s);

        connection.enqueue(new Callback<List<MailingOut>>() {
            @Override
            public void onResponse(Call<List<MailingOut>> call, Response<List<MailingOut>> response) {
                List<MailingOut> mailingOutList = response.body();
                for (int i = 0; i<mailingOutList.size(); i++){
                    if (mailingOutList.get(i).getSubject() == null){
                        mailingOutList.remove(i);
                    }
                }
                showMailingOut(mailingOutList);
                //Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<MailingOut>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void showMailingOut(final List<MailingOut> mailingOutList) {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mailingOutAdapter = new MailingOutAdapter(MailingFollowupActivity.this, mailingOutList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MailingFollowupActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mailingOutAdapter);

        recyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(
                getApplicationContext(), recyclerView, new ClickListener() {

            @Override
            public void onClick(View view, int position) {
                MailingOut mailingOut = mailingOutList.get(position);
                Intent intent = new Intent(MailingFollowupActivity.this, DisplayMailOut.class);
                intent.putExtra("singleMail", mailingOut);
                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
