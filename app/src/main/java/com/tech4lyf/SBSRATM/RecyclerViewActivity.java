package com.tech4lyf.SBSRATM;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterCard;
import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterCyberPlat;
import com.tech4lyf.SBSRATM.Models.Card;
import com.tech4lyf.SBSRATM.Models.CardViewModel;
import com.tech4lyf.SBSRATM.Models.CyberPlat;
import com.tech4lyf.SBSRATM.Models.CyberPlatViewModel;

import java.util.Arrays;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private String type = null;
    private RecyclerView recyclerView;
    private List<CyberPlat> cyberPlats;
    private List<Card> cards;
    private RecyclerViewAdapterCyberPlat recyclerViewAdapterCyberPlat;
    private RecyclerViewAdapterCard recyclerViewAdapterCard;
    private CyberPlatViewModel cyberPlatViewModel;
    private CardViewModel cardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        cyberPlats = Arrays.asList(new CyberPlat[1]);
        cards = Arrays.asList(new Card[1]);
        cyberPlatViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(CyberPlatViewModel.class);
        cardViewModel= ViewModelProviders.of(RecyclerViewActivity.this).get(CardViewModel.class);
        type = getIntent().getStringExtra("TYPE");
        recyclerView = findViewById(R.id.activity_recycler_view_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL, false));



        if (type.equals("CYBERPLAT")) {
            recyclerViewAdapterCyberPlat = new RecyclerViewAdapterCyberPlat(cyberPlats, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterCyberPlat);
            cyberPlatViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(CyberPlatViewModel.class);
            cyberPlatViewModel.getCyberPlats().observe(RecyclerViewActivity.this, new Observer<List<CyberPlat>>() {
                @Override
                public void onChanged(List<CyberPlat> cyberPlats) {
                    recyclerViewAdapterCyberPlat.setCyberPlats(cyberPlats);
                    recyclerViewAdapterCyberPlat.notifyDataSetChanged();

                }
            });
        }

        if (type.equals("CARD")) {
            recyclerViewAdapterCard = new RecyclerViewAdapterCard(cards, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterCard);
            cardViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(CardViewModel.class);
            cardViewModel.getCards().observe(RecyclerViewActivity.this, new Observer<List<Card>>() {
                @Override
                public void onChanged(List<Card> cards) {
                    recyclerViewAdapterCard.setCards(cards);
                    recyclerViewAdapterCard.notifyDataSetChanged();

                }
            });


        }


    }
}
