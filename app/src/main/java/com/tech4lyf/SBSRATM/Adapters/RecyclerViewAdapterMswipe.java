package com.tech4lyf.SBSRATM.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.Models.Mswipe;
import com.tech4lyf.SBSRATM.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class RecyclerViewAdapterMswipe extends RecyclerView.Adapter<RecyclerViewAdapterMswipe.ViewHolder> {
    private List<Mswipe> mswipes;
    private Context context;

    public RecyclerViewAdapterMswipe(List<Mswipe> mswipes, Context context) {
        this.mswipes = mswipes;
        this.context = context;
    }

    public List<Mswipe> getMswipes() {
        return mswipes;
    }

    public void setMswipes(List<Mswipe> mswipes) {
        this.mswipes = mswipes;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_recyclerview_mswipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        if (mswipes.size() > 0) {
            Mswipe mswipe = mswipes.get(position);
            holder.rrNo.setText("RR: " + mswipe.getRRNo());
            holder.amount.setText("Amount(INR): " + mswipe.getAmount());
            holder.cardFirstSixDigits.setText("Card First Six Digits: " + mswipe.getCardFirstSixDigits());
            holder.cardExpiryDate.setText("Card Expiry Date: " + mswipe.getExpiryDate());
            holder.deviceId.setText("Device Id: " + mswipe.getDeviceId());
            holder.mobileNo.setText("Mobile No: " + mswipe.getMobileNo());
            holder.bcid.setText("BCID: " + mswipe.getBcid());
            holder.kioskid.setText("KIOSKID: " + mswipe.getKioskid());
            holder.mid.setText("MID: " + mswipe.getMID());
            holder.tid.setText("TID: " + mswipe.getTID());
            holder.authCode.setText("AuthCode: " + mswipe.getAuthCode());
            holder.transactionStatus.setText("TransactionStatus: " + mswipe.getTransactionStatus());
            holder.tid.setText("TID: " + mswipe.getMobileNo());
            holder.cardHolderName.setText("Card Holder Name: " + mswipe.getCardHolderName());
            holder.date.setText(mswipe.getTransactionDate());


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
        return mswipes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView rrNo;
        TextView amount;
        TextView maskedPan;
        TextView cardFirstSixDigits;
        TextView cardExpiryDate;
        TextView deviceId;
        TextView mobileNo;
        TextView bcid;
        TextView kioskid;
        TextView mid;
        TextView tid;
        TextView authCode;
        TextView transactionStatus;
        TextView cardHolderName;
        TextView date;
        ExpandableLayout expandableLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.list_item_recyclerview_mswipe_cardview);
            rrNo = itemView.findViewById(R.id.list_item_recyclerview_mswipe_rr_no);
            amount = itemView.findViewById(R.id.list_item_recyclerview_mswipe_amount);
            maskedPan = itemView.findViewById(R.id.list_item_recyclerview_mswipe_masked_pan);
            cardFirstSixDigits = itemView.findViewById(R.id.list_item_recyclerview_mswipe_first_six_digits);
            cardExpiryDate = itemView.findViewById(R.id.list_item_recyclerview_mswipe_expiry_date);
            deviceId = itemView.findViewById(R.id.list_item_recyclerview_mswipe_device_id);
            mobileNo = itemView.findViewById(R.id.list_item_recyclerview_mswipe_mobile_no);
            bcid = itemView.findViewById(R.id.list_item_recyclerview_mswipe_bcid);
            kioskid = itemView.findViewById(R.id.list_item_recyclerview_mswipe_kioskid);
            mid = itemView.findViewById(R.id.list_item_recyclerview_mswipe_mid);
            tid = itemView.findViewById(R.id.list_item_recyclerview_mswipe_tid);
            authCode = itemView.findViewById(R.id.list_item_recyclerview_mswipe_authcode);
            transactionStatus = itemView.findViewById(R.id.list_item_recyclerview_mswipe_transaction_status);
            cardHolderName = itemView.findViewById(R.id.list_item_recyclerview_mswipe_holder_name);
            date = itemView.findViewById(R.id.list_item_recyclerview_mswipe_date);
            expandableLayout = itemView.findViewById(R.id.list_item_recyclerview_mswipe_expandable_layout);

        }
    }
}
