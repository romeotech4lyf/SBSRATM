package com.tech4lyf.SBSRATM;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterAeps;
import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterCard;
import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterCyberPlat;
import com.tech4lyf.SBSRATM.Models.Aeps;
import com.tech4lyf.SBSRATM.Models.Card;
import com.tech4lyf.SBSRATM.ViewModels.AepsViewModel;
import com.tech4lyf.SBSRATM.ViewModels.CardViewModel;
import com.tech4lyf.SBSRATM.Models.CyberPlat;
import com.tech4lyf.SBSRATM.ViewModels.CyberPlatViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RadioGroup radioGroup;
    private RadioButton radioButtonRemitterPhone;
    private RadioButton radioButtonDate;
    private RadioButton radioButtonAmount;
    private EditText editTextSearch;
    private CardView cardViewSearch;
    private CardView cardViewClear;
    private String type = null;
    private String searchType = null;
    private String search = null;
    private List<CyberPlat> cyberPlats;
    private List<Card> cards;
    private List<Aeps> aepss;
    private RecyclerViewAdapterCyberPlat recyclerViewAdapterCyberPlat;
    private RecyclerViewAdapterCard recyclerViewAdapterCard;
    private RecyclerViewAdapterAeps recyclerViewAdapterAeps;
    private CyberPlatViewModel cyberPlatViewModel;
    private CardViewModel cardViewModel;
    private AepsViewModel aepsViewModel;
    private EventHandlers eventHandlers = new EventHandlers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        cyberPlats = new ArrayList<>();
        cards = new ArrayList<>();
        aepss = new ArrayList<>();


        type = getIntent().getStringExtra("TYPE");


        //initialize views
        recyclerView = findViewById(R.id.activity_recycler_view_recyclerview);
        radioGroup = findViewById(R.id.activity_recycler_view_radio_group);
        radioButtonRemitterPhone = findViewById(R.id.activity_recycler_view_radio_phone);
        radioButtonAmount = findViewById(R.id.activity_recycler_view_radio_amount);
        radioButtonDate = findViewById(R.id.activity_recycler_view_radio_date);
        editTextSearch = findViewById(R.id.activity_recycler_view_search_edit_text);
        cardViewSearch = findViewById(R.id.activity_recycler_view_search_search);
        cardViewClear = findViewById(R.id.activity_recycler_view_search_clear);

        radioGroup.check(radioButtonAmount.getId());
        searchType = "AMOUNT";

        cardViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search = editTextSearch.getText().toString();
                if (type.equals("CYBERPLAT")) {
                    List<CyberPlat> cyberPlatsSearch = new ArrayList<CyberPlat>(Arrays.asList(new CyberPlat[0]));

                    for (CyberPlat cyberPlat : cyberPlats) {
                        switch (searchType) {
                            case "AMOUNT":
                                if (cyberPlat.getAmount() != null)
                                    if (cyberPlat.getAmount().contains(search))
                                        cyberPlatsSearch.add(cyberPlat);
                                break;

                            case "PHONE":
                                if (cyberPlat.getRemitterPhone() != null)
                                    if (cyberPlat.getRemitterPhone().contains(search))
                                        cyberPlatsSearch.add(cyberPlat);
                                break;

                            case "DATE":
                                if (cyberPlat.getTrans_date() != null)
                                    if (cyberPlat.getTrans_date().contains(search))
                                        cyberPlatsSearch.add(cyberPlat);
                                break;

                            default:
                                break;


                        }


                        recyclerViewAdapterCyberPlat.setCyberPlats(cyberPlatsSearch);
                        recyclerViewAdapterCyberPlat.notifyDataSetChanged();
                        Log.d(search, cyberPlatsSearch.toString());
                    }
                }
                if (type.equals("CARD")) {
                    List<Card> cardsSearch = new ArrayList<Card>(Arrays.asList(new Card[0]));
                    for (Card card : cards) {
                        switch (searchType) {
                            case "AMOUNT":
                                if (card.getAmount() != null)
                                    if (card.getAmount().contains(search))
                                        cardsSearch.add(card);
                                break;

                            case "PHONE":
                                if (card.getMobileNo() != null)
                                    if (card.getMobileNo().contains(search))
                                        cardsSearch.add(card);
                                break;

                            case "DATE":
                                if (card.getTransactionDate() != null)
                                    if (card.getTransactionDate().contains(search))
                                        cardsSearch.add(card);
                                break;

                            default:
                                break;


                        }
                        recyclerViewAdapterCard.setCards(cardsSearch);
                        recyclerViewAdapterCard.notifyDataSetChanged();
                        Log.d(search, cardsSearch.toString());

                    }
                }
            }
        });

        cardViewClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (type.equals("CYBERPLAT")) {
                    recyclerViewAdapterCyberPlat.setCyberPlats(cyberPlats);
                    recyclerViewAdapterCyberPlat.notifyDataSetChanged();
                }
                if (type.equals("CARD")) {
                    recyclerViewAdapterCard.setCards(cards);
                    recyclerViewAdapterCard.notifyDataSetChanged();

                }
            }
        });




      /*  editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString() != null) {
                    search = editable.toString();
                    Log.d(editable.toString(), search);
                    eventHandlers.triggerCyberPlatSearchListener(search,searchType);

                }else
                    eventHandlers.triggerCyberPlatSearchListener(null,searchType);

            }
        });*/

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.activity_recycler_view_radio_phone:
                        searchType = "PHONE";
                        editTextSearch.setHint("Search by Phone Number");
                        break;
                    case R.id.activity_recycler_view_radio_date:
                        searchType = "DATE";
                        editTextSearch.setHint("Search by Transaction Date");
                        break;
                    case R.id.activity_recycler_view_radio_amount:
                        searchType = "AMOUNT";
                        editTextSearch.setHint("Search by Transaction Amount");
                        break;
                    default:
                        break;

                }

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this, LinearLayoutManager.VERTICAL, false));


        if (type.equals("CYBERPLAT")) {
            recyclerViewAdapterCyberPlat = new RecyclerViewAdapterCyberPlat(cyberPlats, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterCyberPlat);
            cyberPlatViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(CyberPlatViewModel.class);
            cyberPlatViewModel.getCyberPlats().observe(RecyclerViewActivity.this, new Observer<List<CyberPlat>>() {
                @Override
                public void onChanged(List<CyberPlat> cyberPlats) {
                    RecyclerViewActivity.this.cyberPlats = cyberPlats;
                    recyclerViewAdapterCyberPlat.setCyberPlats(cyberPlats);
                    recyclerViewAdapterCyberPlat.setSize(cyberPlats.size());
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
                    RecyclerViewActivity.this.cards = cards;
                    recyclerViewAdapterCard.setCards(cards);
                    recyclerViewAdapterCard.notifyDataSetChanged();

                }
            });


        } else if (type.equals("AEPS")) {
            recyclerViewAdapterAeps = new RecyclerViewAdapterAeps(aepss, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterAeps);
            aepsViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(AepsViewModel.class);
            aepsViewModel.getAepss().observe(RecyclerViewActivity.this, new Observer<List<Aeps>>() {
                @Override
                public void onChanged(List<Aeps> aepss) {
                    recyclerViewAdapterAeps.setAepss(aepss);
                    recyclerViewAdapterAeps.notifyDataSetChanged();

                }
            });


        }


    }
}
