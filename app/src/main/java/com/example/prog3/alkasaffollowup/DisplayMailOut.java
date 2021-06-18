package com.example.prog3.alkasaffollowup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.MailingOut;


import java.util.StringTokenizer;

public class DisplayMailOut extends AppCompatActivity {
    private TextView subject, purpose, projectName , emailTo, dateTime;
    private MailingOut recieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mail_out);


        subject=(TextView)findViewById(R.id.singlemailsubject);
        purpose=(TextView)findViewById(R.id.singlemailPurpose);
        projectName=(TextView)findViewById(R.id.singlemailProjectName);
        emailTo=(TextView)findViewById(R.id.singlemailTo);
        dateTime=(TextView)findViewById(R.id.singlemailDateTime);

        recieve = getIntent().getParcelableExtra("singleMail");


        subject.setText(recieve.getSubject());
        purpose.setText(Html.fromHtml(recieve.getPurpose().toString()));
        emailTo.setText(recieve.getToEmployee() + " - " + recieve.getToBranch());

        if (recieve.getProjectName() == null){
            projectName.setText("General");
        }
        else
            projectName.setText(recieve.getProjectName());


        try {

            String s = recieve.getSentDate();
            StringTokenizer tokenizer = new StringTokenizer(s, "T");
            String date = tokenizer.nextToken();
            String time = tokenizer.nextToken();

            StringTokenizer timeTok = new StringTokenizer(time, ":");
            String hours = timeTok.nextToken();
            String minutes = timeTok.nextToken();


            dateTime.setText(date + "    " + hours+":"+minutes);

        }
        catch (Exception e){

        }


    }
}

