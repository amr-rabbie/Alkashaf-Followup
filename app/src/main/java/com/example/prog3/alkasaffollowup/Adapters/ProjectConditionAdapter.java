package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.DesPay;
import com.example.prog3.alkasaffollowup.Model.ProCond;
import com.example.prog3.alkasaffollowup.Model.ProjectCondition;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;

/**
 * Created by prog3 on 3/13/2018.
 */

public class ProjectConditionAdapter  extends BaseAdapter {

    Context context; List<ProjectCondition> projcond;
    public ProjectConditionAdapter(Context context, List<ProjectCondition> projcond) {
        this.context=context;
        this.projcond=projcond;
    }

    @Override
    public int getCount() {
        return projcond.size();
    }

    @Override
    public ProjectCondition getItem(int position) {
        return projcond.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreensViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.project_condition_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        ProjectCondition car = projcond.get(position);

        //holder.img.setImageResource(car.getImage());
        holder.txtcondname.setText(car.getProjCondition());


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
        TextView txtcondname;
        //CardView cview;

        public ScreensViewHolder(View v) {
            //img=v.findViewById(R.id.img);
            txtcondname=v.findViewById(R.id.txtcondname);

            //cview=v.findViewById(R.id.cview);
        }
    }
}
