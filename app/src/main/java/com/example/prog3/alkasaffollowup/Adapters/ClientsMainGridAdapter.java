package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.ClientsScreens;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;

/**
 * Created by prog3 on 3/10/2018.
 */

public class ClientsMainGridAdapter extends BaseAdapter {

    Context context; List<ClientsScreens> screens;
    public ClientsMainGridAdapter(Context context, List<ClientsScreens> screens) {
        this.context=context;
        this.screens=screens;
    }

    @Override
    public int getCount() {
        return screens.size();
    }

    @Override
    public ClientsScreens getItem(int position) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.clientsscreens_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        ClientsScreens car = screens.get(position);

        holder.img.setImageResource(car.getImage());
        holder.txt.setText(car.getName());

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
        ImageView img;
        TextView txt;
        //CardView cview;

        public ScreensViewHolder(View v) {
            img=v.findViewById(R.id.img);
            txt=v.findViewById(R.id.txt);
            //cview=v.findViewById(R.id.cview);
        }
    }
}

