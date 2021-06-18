package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.Project;
import com.example.prog3.alkasaffollowup.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by prog3 on 3/11/2018.
 */

public class ProjectsSpinnerAdapter extends BaseAdapter {

    Context context;  List<Project> projects;



    public ProjectsSpinnerAdapter(Context context, List<Project> projects) {
        this.context=context;
        this.projects=projects;
    }

    @Override
    public int getCount() {
        return projects.size();
    }

    @Override
    public Project getItem(int position) {
        return projects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonViewHolder holder=null;
        if(convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.projects_spinner_row,parent,false);
            holder=new PersonViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(PersonViewHolder) convertView.getTag();
        }

        Project p = projects.get(position);

        holder.txtname.setText(p.getProjName());
        holder.txtsn.setText(p.getSn().toString());

        //Uri uri =  Uri.parse( "http://amrrabbie8484-001-site1.ctempurl.com/images/"+ p.getImg());
        // holder.img.setImageURI(uri);

        //Picasso.with(context).load("http://amrrabbie8484-001-site1.ctempurl.com/images/"+ p.getImg()).into(holder.img);




        return convertView;
    }

    public class PersonViewHolder{
        TextView txtname;
        TextView txtsn;
        //ImageView img;

        public PersonViewHolder(View v) {
            txtname=v.findViewById(R.id.txtpname);
            txtsn=v.findViewById(R.id.txtpid);
            //img=v.findViewById(R.id.vimg);

        }
    }
}
