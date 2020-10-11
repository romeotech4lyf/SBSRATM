package com.tech4lyf.SBSRATM.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.Models.Card;
import com.tech4lyf.SBSRATM.R;

import net.cachapa.expandablelayout.ExpandableLayout;

import java.util.List;

public class RecyclerViewAdapterCard extends RecyclerView.Adapter<RecyclerViewAdapterCard.ViewHolder> {
    private List<Card> cards;
    private Context context;


    public RecyclerViewAdapterCard(List<Card> cards, Context context) {
        this.cards = cards;
        this.context = context;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterCard.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewAdapterCard
                .ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_recyclerview_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapterCard.ViewHolder holder, int position) {
        if (cards.size() > 0) {
            Card card = cards.get(position);
            holder.rrNo.setText("RR: " + card.getRRNo());
            holder.amount.setText("Amount(INR): " + card.getAmount());
            holder.cardFirstSixDigits.setText("Card First Six Digits: " + card.getCardFirstSixDigits());
            holder.cardExpiryDate.setText("Card Expiry Date: " + card.getExpiryDate());
            holder.deviceId.setText("Device Id: " + card.getDeviceId());
            holder.mobileNo.setText("Mobile No: " + card.getMobileNo());
            holder.cardHolderName.setText("Card Holder Name: " + card.getCardHolderName());
            holder.date.setText(card.getTransactionDate());


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
        return cards.size();
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
        TextView cardHolderName;
        TextView date;
        ExpandableLayout expandableLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.list_item_recyclerview_card_cardview);
            rrNo = itemView.findViewById(R.id.list_item_recyclerview_card_rr_no);
            amount = itemView.findViewById(R.id.list_item_recyclerview_card_amount);
            maskedPan = itemView.findViewById(R.id.list_item_recyclerview_card_masked_pan);
            cardFirstSixDigits = itemView.findViewById(R.id.list_item_recyclerview_card_first_six_digits);
            cardExpiryDate = itemView.findViewById(R.id.list_item_recyclerview_card_expiry_date);
            deviceId = itemView.findViewById(R.id.list_item_recyclerview_card_device_id);
            mobileNo = itemView.findViewById(R.id.list_item_recyclerview_card_mobile_no);
            cardHolderName = itemView.findViewById(R.id.list_item_recyclerview_card_holder_name);
            date = itemView.findViewById(R.id.list_item_recyclerview_card_date);
            expandableLayout = itemView.findViewById(R.id.list_item_recyclerview_card_expandable_layout);
        }
    }
}
