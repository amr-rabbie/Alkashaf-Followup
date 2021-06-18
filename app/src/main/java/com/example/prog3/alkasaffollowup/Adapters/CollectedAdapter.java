package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Model.ProjColl.ProjectCollected;
import com.example.prog3.alkasaffollowup.ProjCollectedFollowup;
import com.example.prog3.alkasaffollowup.R;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prog3 on 3/26/2018.
 */

public class CollectedAdapter extends BaseAdapter {
    Context context; List<ProjectCollected> collectedList; String ref;
    public CollectedAdapter(Context context, List<ProjectCollected> collectedList, String ref) {
        this.context=context;
        this.collectedList=collectedList;
        this.ref=ref;
    }

    @Override
    public int getCount() {
        return collectedList.size();
    }

    @Override
    public ProjectCollected getItem(int position) {
        return collectedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CollectedViewHolder holder=null;
        if(convertView == null){
            convertView=LayoutInflater.from(context).inflate(R.layout.project_collected_row,parent,false);
            holder=new CollectedViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder=(CollectedViewHolder) convertView.getTag();
        }

        ProjectCollected collected = collectedList.get(position);

        String s =collected.getInvoiceDate();
        StringTokenizer tokenizer = new StringTokenizer(s, "T");
        String invoicedate = tokenizer.nextToken();

        holder.txtprojref.setText(ref);
        holder.txtinvoice.setText(collected.getInvoiceNumber());
        holder.txtinvoiceamount.setText(collected.getInvoiceAmount());
        holder.txtinvoicedate.setText(invoicedate);

        return convertView;
    }

    public class CollectedViewHolder{
        TextView txtprojref,txtinvoice,txtinvoiceamount,txtinvoicedate;
        CardView cview;
        public CollectedViewHolder(View v) {
            txtprojref=v.findViewById(R.id.txtprojref);
            txtinvoice=v.findViewById(R.id.txtinvoice);
            txtinvoiceamount=v.findViewById(R.id.txtinvoiceamount);
            txtinvoicedate=v.findViewById(R.id.txtinvoicedate);

            cview=v.findViewById(R.id.cview);



        }
    }



}
