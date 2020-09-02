package com.tech4lyf.SBSRATM.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.EventHandlers;
import com.tech4lyf.SBSRATM.Models.CyberPlat;
import com.tech4lyf.SBSRATM.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class RecyclerViewAdapterCyberPlat extends RecyclerView.Adapter<RecyclerViewAdapterCyberPlat.ViewHolder>  {
    private List<CyberPlat> cyberPlats;
    private List<CyberPlat> cyberPlatsSearch;
    private List<CyberPlat> cyberPlatsTemp;
    private Context context;
    private int size =0;

    public void setSize(int size) {
        this.size = size;
    }

    private EventHandlers eventHandlers = new EventHandlers();

    public RecyclerViewAdapterCyberPlat(List<CyberPlat> cyberPlats, Context context) {
        this.cyberPlats = cyberPlats;
        this.cyberPlatsSearch=cyberPlats;
        this.cyberPlatsTemp=cyberPlats;
        this.size = cyberPlats.size();
        this.context = context;
    }


    public List<CyberPlat> getCyberPlats() {
        return cyberPlats;
    }

    public void setCyberPlats(List<CyberPlat> cyberPlats) {
        this.cyberPlats = cyberPlats;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_recyclerview_cyber_plat, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        if (cyberPlats.size() > 0) {
            CyberPlat cyberPlat = cyberPlats.get(position);
            holder.ipayId.setText("Id: " + cyberPlat.getIpay_id());
            holder.amount.setText("Amount(INR): " + cyberPlat.getAmount());
            holder.beneficiaryId.setText("Beneficiary Id: " + cyberPlat.getBeneficiaryID());
            holder.beneficiaryPhoneNo.setText("Beneficiary Phone No: " + cyberPlat.getBeneficiaryPhone());
            holder.remitterId.setText("Remitter Id: " + cyberPlat.getRemitterID());
            holder.remitterPhoneNo.setText("Remitter Phone No: " + cyberPlat.getRemitterPhone());
            holder.refNo.setText("Ref no: " + cyberPlat.getRef_no());
            holder.oprId.setText("Opr Id: " + cyberPlat.getOpr_id());
            holder.name.setText("Name: " + cyberPlat.getName());
            holder.chargedAmount.setText("Charged(INR): " + cyberPlat.getCharged_amt());


            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (holder.expandableLayout.isExpanded())
                        holder.expandableLayout.collapse();
                    else
                        holder.expandableLayout.expand();

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return cyberPlats.size();
    }


   /* public void onCyberPlatSearch(String search, final String searchType) {
        if (search != null && searchType!=null) {

            cyberPlatsSearch.clear();

            Log.d(search, "searchType");
            switch (searchType) {
                case "PHONE":
                    for (CyberPlat cyberPlat : cyberPlats)
                        if (cyberPlat.getRemitterPhone().contains(search))
                            cyberPlatsSearch.add(cyberPlat);

                        break;

                case "DATE":
                    for (CyberPlat cyberPlat : cyberPlats)
                        if (cyberPlat.getSD().contains(search))
                            cyberPlatsSearch.add(cyberPlat);

                    break;

                case "AMOUNT":
                    for (CyberPlat cyberPlat : this.cyberPlats)
                        if (cyberPlat.getAmount().contains(search))
                            this.cyberPlatsSearch.add(cyberPlat);
                    Log.d("amount",this.cyberPlats.toString());

                    break;

                default:break;
            }

            if(cyberPlatsSearch.size()==0) {
                Log.d(search, "Not Found");
                this.setCyberPlats(this.cyberPlats);
            }
            this.setCyberPlats(this.cyberPlatsSearch);
            this.setSize(this.cyberPlatsSearch.size());
            this.notifyDataSetChanged();

            }

        }*/




    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView ipayId;
        TextView amount;
        TextView beneficiaryId;
        TextView beneficiaryPhoneNo;
        TextView remitterId;
        TextView remitterPhoneNo;
        TextView refNo;
        TextView oprId;
        TextView name;
        TextView chargedAmount;
        ExpandableLayout expandableLayout;

        ViewHolder(View itemView) {
            super(itemView);
            ipayId = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_ipay_id);
            amount = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_amount);
            beneficiaryId = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_beneficiary_id);
            beneficiaryPhoneNo = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_beneficiary_phone_no);
            remitterId = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_remitter_id);
            remitterPhoneNo = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_remitter_phone_no);
            refNo = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_ref_no);
            oprId = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_opr_id);
            name = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_name);
            chargedAmount = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_charged_amt);
            expandableLayout = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_expandable_layout);
            cardView = itemView.findViewById(R.id.list_item_recyclerview_cyber_plat_cardview);
        }
    }

}
