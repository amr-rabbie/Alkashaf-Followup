package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.MailingOut;
import com.example.prog3.alkasaffollowup.R;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class MailingOutAdapter extends RecyclerView.Adapter<MailingOutAdapter.MyViewHolder> {

    private Context context;
    private List<MailingOut> mailingOutList;

    public MailingOutAdapter(Context context, List<MailingOut> mailingOutList) {
        this.context = context;
        this.mailingOutList = mailingOutList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.mailingout_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.subject.setText(mailingOutList.get(position).getSubject());
        holder.employee.setText(mailingOutList.get(position).getToEmployee());
        holder.branch.setText(mailingOutList.get(position).getToBranch());

        try {

            String s =mailingOutList.get(position).getSentDate();
            StringTokenizer tokenizer = new StringTokenizer(s, "T");
            String date = tokenizer.nextToken();
            String time = tokenizer.nextToken();
            System.out.println("Dir 1  : " + date);
            System.out.println("Dir 2 : " + time);

            StringTokenizer tok = new StringTokenizer(date, "-");
            String year = tok.nextToken();
            String month = tok.nextToken();
            String day = tok.nextToken();

            StringTokenizer timeTok = new StringTokenizer(time, ":");
            String hours = timeTok.nextToken();
            String minutes = timeTok.nextToken();

            int mid = year.length()/2;
            String []parts = {year.substring(0, mid), year.substring(mid)};


            holder.day.setText(day);
            holder.month.setText(getMonthAsText(month));
            holder.time.setText(hours+":"+minutes);
            holder.year.setText(parts[1]);



        }
        catch (Exception e){
            holder.day.setText("");
        }





    }

    private String getMonthAsText(String month) {
        int monthConverter = Integer.parseInt(month);
        String monthText = null;
        switch (monthConverter){
            case 01:
                monthText="Jan";
                break;
            case 02:
                monthText="Feb";
                break;
            case 03:
                monthText="Mar";
                break;
            case 04:
                monthText="Apr";
                break;
            case 05:
                monthText="May";
                break;
            case 06:
                monthText="Jun";
                break;
            case 07:
                monthText="Jul";
                break;
            case 8:
                monthText="Aug";
                break;
            case 9:
                monthText="Sep";
                break;
            case 10:
                monthText="Oct";
                break;
            case 11:
                monthText="Nov";
                break;
            case 12:
                monthText="Dec";
                break;

        }

        return monthText;
    }

    @Override
    public int getItemCount() {
        return mailingOutList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView subject, employee, day, month, year, time, branch;

        public MyViewHolder(View itemView) {
            super(itemView);
            subject=(TextView)itemView.findViewById(R.id.txtshowsubject);
            employee=(TextView)itemView.findViewById(R.id.txtshowemployee);
            day=(TextView)itemView.findViewById(R.id.txtshowdateday);
            month=(TextView)itemView.findViewById(R.id.txtshowdatemonth);
            time=(TextView)itemView.findViewById(R.id.txtshowtime);
            branch=(TextView)itemView.findViewById(R.id.txtshowbranch);
            year=(TextView)itemView.findViewById(R.id.txtshowdateyear);

        }
    }
}

