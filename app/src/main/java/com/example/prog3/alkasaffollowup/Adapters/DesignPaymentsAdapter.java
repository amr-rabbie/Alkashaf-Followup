package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.DesPay;
import com.example.prog3.alkasaffollowup.Model.DesignPay.Detail;
import com.example.prog3.alkasaffollowup.Model.DesignPayement;
import com.example.prog3.alkasaffollowup.Model.SchFees;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;

/**
 * Created by prog3 on 3/12/2018.
 *
 *
 */

public class DesignPaymentsAdapter  extends BaseAdapter {

    String payename;

    Context context; List<com.example.prog3.alkasaffollowup.Model.DesignPay.DesignPayement> designPayements;
    public DesignPaymentsAdapter(Context context, List<com.example.prog3.alkasaffollowup.Model.DesignPay.DesignPayement> designPayements) {
        this.context=context;
        this.designPayements=designPayements;
    }

    @Override
    public int getCount() {
        return designPayements.size();
    }

    @Override
    public com.example.prog3.alkasaffollowup.Model.DesignPay.DesignPayement getItem(int position) {
        return designPayements.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreensViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.design_payments_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        com.example.prog3.alkasaffollowup.Model.DesignPay.DesignPayement designPayement = designPayements.get(position);

        //holder.img.setImageResource(designPayement.getImage());


      int payname=designPayement.getPaymentIndex();

       if(payname == 1){
          payename="1st";
      }else if(payname == 2){
           payename="2nd";
      }else if(payname == 3){
           payename="3rd";
      }else if(payname > 3 ) {
           payename=payname+"th";
      }else{
           payename="Down";
       }


        holder.txtpayname.setText(payename);

        holder.txtpaytype.setText(designPayement.getPaymentType());

        holder.txtnotes.setText(designPayement.getNotes());


        List<Detail> details = designPayement.getDetails();

        for(int i=0;i<details.size();i++){
            Detail detail = details.get(i);

            holder.txtscope.setText(detail.getScope());

            holder.txtvalue.setText(detail.getPerc()+"%");



        }










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
        TextView txtpayname,txtscope,txtvalue,txtnotes,txtpaytype;
        //CardView cview;

        public ScreensViewHolder(View v) {
            //img=v.findViewById(R.id.img);
            txtscope=v.findViewById(R.id.txtscope);
            txtvalue=v.findViewById(R.id.txtvalue);
            txtpayname=v.findViewById(R.id.txtpayname);
            txtnotes=v.findViewById(R.id.txtnotes);
            txtpaytype=v.findViewById(R.id.txtpaytype);
            //cview=v.findViewById(R.id.cview);
        }
    }
}
