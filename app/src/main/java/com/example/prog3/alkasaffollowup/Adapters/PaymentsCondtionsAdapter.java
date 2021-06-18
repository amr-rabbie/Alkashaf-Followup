package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.DesPay;
import com.example.prog3.alkasaffollowup.Model.PayCond;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;

/**
 * Created by prog3 on 3/17/2018.
 */

public class PaymentsCondtionsAdapter  extends BaseAdapter {

    Context context; List<PayCond> screens;
    public PaymentsCondtionsAdapter(Context context, List<PayCond> screens) {
        this.context=context;
        this.screens=screens;
    }

    @Override
    public int getCount() {
        return screens.size();
    }

    @Override
    public PayCond getItem(int position) {
        return screens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreensViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.payments_conditions_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        PayCond car = screens.get(position);

        //holder.img.setImageResource(car.getImage());
        holder.txtscope.setText(car.getScope());
        holder.txtvalue.setText(car.getValue());
        holder.txtnotes.setText(car.getNotes());
        holder.txtpayname.setText(car.getPayname());
        holder.txtpaytype.setText(car.getPaytype());

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
