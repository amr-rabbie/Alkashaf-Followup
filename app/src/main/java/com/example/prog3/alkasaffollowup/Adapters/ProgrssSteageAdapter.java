package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.Model.ProgSteg;
import com.example.prog3.alkasaffollowup.Model.ProgStg.ProgressSteage;
import com.example.prog3.alkasaffollowup.Model.ProgStg.ProjWorkscopeList;
import com.example.prog3.alkasaffollowup.Model.ProgStg.Project;
import com.example.prog3.alkasaffollowup.Model.ReqFolUp;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prog3 on 3/17/2018.
 */

public class ProgrssSteageAdapter extends BaseAdapter {

    Context context; List<ProgressSteage> progressSteages;
    public ProgrssSteageAdapter(Context context, List<ProgressSteage> progressSteages) {
        this.context=context;
        this.progressSteages=progressSteages;
    }

    @Override
    public int getCount() {
        return progressSteages.size();
    }

    @Override
    public ProgressSteage getItem(int position) {
        return progressSteages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ScreensViewHolder holder=null;
        if(convertView ==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.progress_steage_row,parent,false);
            holder=new ScreensViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(ScreensViewHolder) convertView.getTag();
        }

        ProgressSteage  progressSteage = progressSteages.get(position);

        //holder.img.setImageResource(car.getImage());

        Project project = progressSteage.getProject();

        ProjWorkscopeList projWorkscopeList = project.getProjWorkscopeList();


        String s =progressSteage.getContractDate();
        StringTokenizer tokenizer = new StringTokenizer(s, "T");
        String contdate = tokenizer.nextToken();

        String s1 =progressSteage.getDocumentRecvDate();
        StringTokenizer tokenizer2 = new StringTokenizer(s1, "T");
        String drd = tokenizer2.nextToken();

        String s2 =progressSteage.getProgstartDate();
        StringTokenizer tokenizer3 = new StringTokenizer(s2, "T");
        String inprogdate = tokenizer3.nextToken();



        holder.txtprojref.setText(project.getProjRef());
        holder.txtcontdate.setText(contdate);
        holder.txtprogsteg.setText(project.getProgressStage());
        holder.txtdrd.setText(drd);
        holder.txtinprogdate.setText(inprogdate);

        holder.txtwscope.setText(projWorkscopeList.getName());


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
        TextView txtprojref,txtcontdate,txtprogsteg,txtdrd,txtinprogdate,txtwscope;
        //CardView cview;

        public ScreensViewHolder(View v) {
            //img=v.findViewById(R.id.img);
            txtprojref=v.findViewById(R.id.txtprojref);
            txtcontdate=v.findViewById(R.id.txtcontdate);
            txtprogsteg=v.findViewById(R.id.txtprogsteg);
            txtdrd=v.findViewById(R.id.txtdrd);
            txtinprogdate=v.findViewById(R.id.txtinprogdate);
            txtwscope=v.findViewById(R.id.txtwscope);


            //cview=v.findViewById(R.id.cview);
        }
    }
}
