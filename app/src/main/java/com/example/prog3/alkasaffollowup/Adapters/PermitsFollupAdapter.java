package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.Perm.PermitFollowup;
import com.example.prog3.alkasaffollowup.Model.PermFolUp;
import com.example.prog3.alkasaffollowup.Model.ReqFolUp;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prog3 on 3/13/2018.
 */

public class PermitsFollupAdapter extends BaseAdapter {

    Context context; List<PermitFollowup> permitFollowups;
    public PermitsFollupAdapter(Context context, List<PermitFollowup> permitFollowups) {
        this.context=context;
        this.permitFollowups=permitFollowups;
    }

    @Override
    public int getCount() {
        return permitFollowups.size();
    }

    @Override
    public PermitFollowup getItem(int position) {
        return permitFollowups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreensViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.permits_followup_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        PermitFollowup permitFollowup = permitFollowups.get(position);

        //holder.img.setImageResource(car.getImage());

        String s =permitFollowup.getLastDate();
        StringTokenizer tokenizer = new StringTokenizer(s, "T");
        String date = tokenizer.nextToken();



        holder.txtpermid.setText(permitFollowup.getPermitId());
        holder.txtprojref.setText(permitFollowup.getProjRef());
        holder.txtpermtype.setText(permitFollowup.getPermitType());
        holder.txtlstatus.setText(permitFollowup.getLastStatusName());
        holder.txtdate.setText(date);
        holder.txtaddress.setText(permitFollowup.getAddreessee());


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
        TextView txtpermid,txtprojref,txtpermtype,txtlstatus,txtdate,txtaddress;
        //CardView cview;

        public ScreensViewHolder(View v) {
            //img=v.findViewById(R.id.img);
            txtpermid=v.findViewById(R.id.txtpermid);
            txtprojref=v.findViewById(R.id.txtprojref);
            txtpermtype=v.findViewById(R.id.txtpermtype);
            txtlstatus=v.findViewById(R.id.txtlstatus);
            txtdate=v.findViewById(R.id.txtdate);
            txtaddress=v.findViewById(R.id.txtaddress);


            //cview=v.findViewById(R.id.cview);
        }
    }
}
