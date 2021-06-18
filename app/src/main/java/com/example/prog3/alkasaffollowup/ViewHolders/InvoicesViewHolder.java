package com.example.prog3.alkasaffollowup.ViewHolders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.prog3.alkasaffollowup.R;

/**
 * Created by prog3 on 3/26/2018.
 */

public class InvoicesViewHolder extends RecyclerView.ViewHolder {
    public TextView txtprojref,txtinvoice,txtinvoiceamount,txtinvoicedate;
    public CardView cview;
    public InvoicesViewHolder(View v) {
        super(v);
        txtprojref=v.findViewById(R.id.txtprojref);
        txtinvoice=v.findViewById(R.id.txtinvoice);
        txtinvoiceamount=v.findViewById(R.id.txtinvoiceamount);
        txtinvoicedate=v.findViewById(R.id.txtinvoicedate);

        cview=v.findViewById(R.id.cview);
    }
}
