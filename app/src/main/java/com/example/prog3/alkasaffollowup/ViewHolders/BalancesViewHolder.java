package com.example.prog3.alkasaffollowup.ViewHolders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.R;

/**
 * Created by prog3 on 3/27/2018.
 */

public class BalancesViewHolder extends RecyclerView.ViewHolder {
    public CardView cview;
    public TextView txtscope,txtfees,txtinvoiced,txtcollected,txtbalance;
    public BalancesViewHolder(View v) {
        super(v);
        txtscope=v.findViewById(R.id.txtscope);
        txtfees=v.findViewById(R.id.txtfees);
        txtinvoiced=v.findViewById(R.id.txtinvoiced);
        txtcollected=v.findViewById(R.id.txtcollected);
        txtbalance=v.findViewById(R.id.txtbalance);


    }
}
