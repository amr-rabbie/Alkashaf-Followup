package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.DesPay;
import com.example.prog3.alkasaffollowup.Model.Req.Requirment;
import com.example.prog3.alkasaffollowup.Model.ReqFolUp;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prog3 on 3/13/2018.
 */

public class ReqirmentsFollUpAdapter extends BaseAdapter {

    Context context; List<Requirment> requirments;
    public ReqirmentsFollUpAdapter(Context context, List<Requirment> requirments) {
        this.context=context;
        this.requirments=requirments;
    }

    @Override
    public int getCount() {
        return requirments.size();
    }

    @Override
    public Requirment getItem(int position) {
        return requirments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreensViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.reqirment_followup_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        Requirment requirment = requirments.get(position);

        //holder.img.setImageResource(car.getImage());

        //holder.txtprojname.setText(requirment.getProjName());
        //holder.txtprojsn.setText(requirment.getProjRef());


            String s = requirment.getActionDate();
            StringTokenizer tokenizer = new StringTokenizer(s, "T");
            String actdate = tokenizer.nextToken();


            /*
            String s1 = requirment.getNextFollowupDate();
            StringTokenizer tokenizer2 = new StringTokenizer(s1, "T");
            String nextdate = tokenizer2.nextToken();
            */


        holder.txtreqname.setText(requirment.getRequuirementName());
        holder.txtpername.setText(requirment.getPermitName());
        holder.txtscope.setText(requirment.getScope());
        holder.txtstatus.setText(requirment.getStatusName());
        holder.txtactdate.setText(actdate);
        holder.txtcomment.setText(requirment.getLastComment());
        holder.txtnextfolup.setText(requirment.getNextFollowupDate());

        //holder.cview.setTag(position);

        /*
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=(int)v.getTag();
                Car c = cars.get(position);

                Toast.makeText(context,"car name: "+c.getName(),Toast.LENGTH_LONG).show();

            }
        });

        convertView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position=(int)v.getTag();
                Car c = cars.get(position);

                Intent i=new Intent(context,CarDetails.class);
                i.putExtra("c",c);
                context.startActivity(i);
                return false;
            }
        });
*/

        return convertView;
    }

    public class ScreensViewHolder{
        //ImageView img;
        TextView txtprojname,txtprojsn,txtreqname,txtpername,txtscope,txtstatus,txtactdate,txtcomment,txtnextfolup;
        //CardView cview;

        public ScreensViewHolder(View v) {
            //img=v.findViewById(R.id.img);
            //txtprojname=v.findViewById(R.id.txtprojname);
            //txtprojsn=v.findViewById(R.id.txtprojsn);
            txtreqname=v.findViewById(R.id.txtreqname);
            txtpername=v.findViewById(R.id.txtpername);
            txtscope=v.findViewById(R.id.txtscope);
            txtstatus=v.findViewById(R.id.txtstatus);
            txtactdate=v.findViewById(R.id.txtactiondate);
            txtcomment=v.findViewById(R.id.txtcommment);
            txtnextfolup=v.findViewById(R.id.txtnextfolup);

            //cview=v.findViewById(R.id.cview);
        }
    }
}
