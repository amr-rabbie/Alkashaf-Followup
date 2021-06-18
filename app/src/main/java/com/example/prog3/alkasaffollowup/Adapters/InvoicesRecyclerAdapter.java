package com.example.prog3.alkasaffollowup.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prog3.alkasaffollowup.Model.ProjInvoi.ProjectInvoice;
import com.example.prog3.alkasaffollowup.ProjInvoicesFollowup;
import com.example.prog3.alkasaffollowup.R;
import com.example.prog3.alkasaffollowup.ViewHolders.InvoicesViewHolder;

import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by prog3 on 3/26/2018.
 */

public class InvoicesRecyclerAdapter extends RecyclerView.Adapter<InvoicesViewHolder> {
    Context context; List<ProjectInvoice> invoices;String ref;
    public InvoicesRecyclerAdapter(Context context, List<ProjectInvoice> invoices,String ref) {
        this.context=context;
        this.invoices=invoices;
        this.ref=ref;
    }

    @Override
    public InvoicesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.project_invoices_row, parent, false);
        return new  InvoicesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InvoicesViewHolder holder, int position) {

        ProjectInvoice invoice = invoices.get(position);

        String s =invoice.getInvoiceDate();
        StringTokenizer tokenizer = new StringTokenizer(s, "T");
        String invoicedate = tokenizer.nextToken();

        holder.txtprojref.setText(ref);
        holder.txtinvoice.setText(invoice.getInvoiceNumber());
        holder.txtinvoiceamount.setText(invoice.getInvoiceAmount());
        holder.txtinvoicedate.setText(invoicedate);

    }

    @Override
    public int getItemCount() {
        return invoices.size();
    }
}
