package com.tech4lyf.SBSRATM.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.Models.DMT;
import com.tech4lyf.SBSRATM.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class RecyclerViewAdapterDMT extends RecyclerView.Adapter<RecyclerViewAdapterDMT.ViewHolder> {
    private List<DMT> dmts;
    private Context context;

    public RecyclerViewAdapterDMT(List<DMT> dmts, Context context) {
        this.dmts = dmts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_recyclerview_dmt, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (dmts.size() > 0) {
            DMT dmt = dmts.get(position);
            holder.ipayId.setText("ID: " + dmt.getIpay_id());
            holder.amount.setText("Amount(INR): " + dmt.getCharged_amt());
            holder.sd.setText("SD: " + dmt.getSD());
            holder.ap.setText("ap: " + dmt.getAP());
            holder.op.setText("OP: " + dmt.getOP());
            holder.sessionNo.setText("Session NO: " + dmt.getSessionNo());
            holder.bcid.setText("BCID: " + dmt.getBcid());
            holder.kioskid.setText("KIOSKID: " + dmt.getKioskid());
            holder.remitterId.setText("Remitter Id: " + dmt.getRemitterID());
            holder.remitter_phone.setText("Remitter Phone: " + dmt.getRemitterPhone());
            holder.benificiary_id.setText("Benificiary Id: " + dmt.getBeneficiaryID());
            holder.benificiary_phone.setText("Benificiary Phone: " + dmt.getBeneficiaryPhone());
            holder.routerType.setText("Router Type: " + dmt.getBeneficiaryPhone());
            holder.lockedAmount.setText("Locked Amount: " + dmt.getBeneficiaryPhone());
            holder.refNo.setText("Ref No: " + dmt.getBeneficiaryPhone());
            holder.oprId.setText("Opr Id: " + dmt.getBeneficiaryPhone());
            holder.transactionStatus.setText("TransactionStatus: " + dmt.getTransferStatus());
            holder.cardHolderName.setText("Name: " + dmt.getName());
            holder.date.setText("Time: " + dmt.getTrans_date() + " " + dmt.getTrans_time());
        }

    }

    public List<DMT> getDmts() {
        return dmts;
    }

    public void setDmts(List<DMT> dmts) {
        this.dmts = dmts;
    }

    @Override
    public int getItemCount() {
        return dmts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView amount;
        TextView ipayId;
        TextView sd;
        TextView ap;
        TextView op;
        TextView sessionNo;
        TextView bcid;
        TextView kioskid;
        TextView remitterId;
        TextView remitter_phone;
        TextView benificiary_id;
        TextView benificiary_phone;
        TextView routerType;
        TextView lockedAmount;
        TextView refNo;
        TextView oprId;
        TextView transactionStatus;
        TextView cardHolderName;
        TextView date;
        ExpandableLayout expandableLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.list_item_recyclerview_dmt_cardview);
            ipayId = itemView.findViewById(R.id.list_item_recyclerview_dmt_ipay_id);
            amount = itemView.findViewById(R.id.list_item_recyclerview_dmt_amount);
            sd = itemView.findViewById(R.id.list_item_recyclerview_dmt_sd);
            ap = itemView.findViewById(R.id.list_item_recyclerview_dmt_ap);
            op = itemView.findViewById(R.id.list_item_recyclerview_dmt_op);
            sessionNo = itemView.findViewById(R.id.list_item_recyclerview_dmt_session_no);
            bcid = itemView.findViewById(R.id.list_item_recyclerview_dmt_bcid);
            kioskid = itemView.findViewById(R.id.list_item_recyclerview_dmt_kioskid);
            remitterId = itemView.findViewById(R.id.list_item_recyclerview_dmt_remitter_id);
            remitter_phone = itemView.findViewById(R.id.list_item_recyclerview_dmt_remitter_phone);
            benificiary_id = itemView.findViewById(R.id.list_item_recyclerview_dmt_benificiary_id);
            benificiary_phone = itemView.findViewById(R.id.list_item_recyclerview_dmt_benificiary_phone);
            routerType = itemView.findViewById(R.id.list_item_recyclerview_dmt_router_type);
            lockedAmount = itemView.findViewById(R.id.list_item_recyclerview_dmt_locked_amount);
            refNo = itemView.findViewById(R.id.list_item_recyclerview_dmt_ref_no);
            oprId = itemView.findViewById(R.id.list_item_recyclerview_dmt_opr_id);
            transactionStatus = itemView.findViewById(R.id.list_item_recyclerview_dmt_transaction_status);
            cardHolderName = itemView.findViewById(R.id.list_item_recyclerview_dmt_holder_name);
            date = itemView.findViewById(R.id.list_item_recyclerview_dmt_date_time);
            expandableLayout = itemView.findViewById(R.id.list_item_recyclerview_dmt_expandable_layout);
        }
    }
}
