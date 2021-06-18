package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.prog3.alkasaffollowup.Model.ProjBal.ProjectBalance;
import com.example.prog3.alkasaffollowup.ProjBalance;
import com.example.prog3.alkasaffollowup.R;
import com.example.prog3.alkasaffollowup.ViewHolders.BalancesViewHolder;

import java.util.List;

/**
 * Created by prog3 on 3/27/2018.
 */

public class BalancesRecyclerAdapter extends RecyclerView.Adapter<BalancesViewHolder> {
    Context context; List<ProjectBalance> balances;
    public BalancesRecyclerAdapter(Context context, List<ProjectBalance> balances) {
        this.context=context;
        this.balances=balances;
    }

    @Override
    public BalancesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.project_balance_row, parent, false);
/*
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (int)v.getTag();
                ProjectBalance balance = balances.get(pos);



                Toast.makeText(context,balance.getProjName(),Toast.LENGTH_LONG).show();
                Toast.makeText(context,balance.getProjRef(),Toast.LENGTH_LONG).show();
                Toast.makeText(context,balance.getClientName(),Toast.LENGTH_LONG).show();
            }
        });
*/

        return new BalancesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BalancesViewHolder holder, int position) {

        ProjectBalance balance = balances.get(position);

        holder.txtscope.setText(balance.getScope());
        holder.txtfees.setText(balance.getValue().toString());
        holder.txtcollected.setText(balance.getCollected().toString());
        holder.txtinvoiced.setText(balance.getInvoices().toString());
        holder.txtbalance.setText(balance.getBalance().toString());

        //holder.cview.setTag(position);

    }

    @Override
    public int getItemCount() {
        return balances.size();
    }
}
