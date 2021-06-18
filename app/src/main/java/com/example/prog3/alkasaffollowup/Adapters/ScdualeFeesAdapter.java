package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.ClientsScreens;
import com.example.prog3.alkasaffollowup.Model.ProjectFee;
import com.example.prog3.alkasaffollowup.Model.ProjectFees.PaymentsScopeList;
import com.example.prog3.alkasaffollowup.Model.SchFees;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;

/**
 * Created by prog3 on 3/12/2018.
 */

public class ScdualeFeesAdapter extends BaseAdapter {

    Context context; List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee> projfees;
    public ScdualeFeesAdapter(Context context, List<com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee> projfees) {
        this.context=context;
        this.projfees=projfees;
    }

    @Override
    public int getCount() {
        return projfees.size();
    }

    @Override
    public com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee getItem(int position) {
        return projfees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreensViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.scdulae_fees_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        com.example.prog3.alkasaffollowup.Model.ProjectFees.ProjectFee projectFee = projfees.get(position);

        //holder.img.setImageResource(car.getImage());

        PaymentsScopeList paymentsScopeList = projectFee.getPaymentsScopeList();

        holder.txtscope.setText(paymentsScopeList.getName());
        holder.txtvalue.setText(projectFee.getValue().toString());
        //holder.txtcontdate.setText(car.getContdate());
        //holder.txtexpdate.setText(car.getExpdate());

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
        TextView txtscope,txtvalue,txtcontdate,txtexpdate;
        //CardView cview;

        public ScreensViewHolder(View v) {
            //img=v.findViewById(R.id.img);
            txtscope=v.findViewById(R.id.txtscope);
            txtvalue=v.findViewById(R.id.txtvalue);
            //txtcontdate=v.findViewById(R.id.txtcontdate);
            //txtexpdate=v.findViewById(R.id.txtexpdate);
            //cview=v.findViewById(R.id.cview);
        }
    }
}
