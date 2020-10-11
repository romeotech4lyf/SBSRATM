package com.tech4lyf.SBSRATM.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.Models.Aeps;
import com.tech4lyf.SBSRATM.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class RecyclerViewAdapterAeps extends RecyclerView.Adapter<RecyclerViewAdapterAeps.ViewHolder> {


    private List<Aeps> aepss;
    private Context context;

    public RecyclerViewAdapterAeps(List<Aeps> aepss, Context context) {
        this.aepss = aepss;
        this.context = context;
    }


    public List<Aeps> getAepss() {
        return aepss;
    }

    public void setAepss(List<Aeps> aepss) {
        this.aepss = aepss;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterAeps.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterAeps.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_recycler_view_aeps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterAeps.ViewHolder holder, int position) {
        if (aepss.size() > 0) {
            Aeps aeps = aepss.get(position);
            holder.retailerId.setText("RId: " + aeps.getRetailerId());
            holder.amount.setText("Amount(INR): " + aeps.getAmount());
            holder.transactionId.setText("Transaction Id: " + aeps.getTransactionId());
            holder.kioskid.setText("Kioskid: " + aeps.getKioskid());
            holder.bcid.setText("BCID " + aeps.getBcid());
            holder.serviceProviderId.setText("Service Provider Id " + aeps.getServiceProviderId());
            holder.transactionDate.setText("Date: " + aeps.getDateTime());
            holder.totalAmount.setText("Total Amount(INR): " + aeps.getTotalAmount());


            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.expandableLayout.toggle();


                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return aepss.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView retailerId;
        private TextView amount;
        private TextView transactionId;
        private TextView kioskid;
        private TextView bcid;
        private TextView serviceProviderId;
        private TextView transactionDate;
        private TextView totalAmount;
        private ExpandableLayout expandableLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            retailerId = itemView.findViewById(R.id.list_item_recyclerview_aeps_retailer_id);
            amount = itemView.findViewById(R.id.list_item_recyclerview_aeps_amount);
            transactionId = itemView.findViewById(R.id.list_item_recyclerview_aeps_transaction_id);
            kioskid = itemView.findViewById(R.id.list_item_recyclerview_aeps_kioskid);
            bcid = itemView.findViewById(R.id.list_item_recyclerview_aeps_bcid);
            serviceProviderId = itemView.findViewById(R.id.list_item_recyclerview_aeps_service_provider_id);
            transactionDate = itemView.findViewById(R.id.list_item_recyclerview_aeps_trans_date);
            totalAmount = itemView.findViewById(R.id.list_item_recyclerview_aeps_total_amount);
            expandableLayout = itemView.findViewById(R.id.list_item_recyclerview_aeps_expandable_layout);
            cardView = itemView.findViewById(R.id.list_item_recyclerview_aeps_cardview);
        }
    }

}



