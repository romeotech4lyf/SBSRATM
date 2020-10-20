package com.tech4lyf.SBSRATM;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterAeps;
import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterCard;
import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterCyberPlat;
import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterDMT;
import com.tech4lyf.SBSRATM.Adapters.RecyclerViewAdapterMswipe;
import com.tech4lyf.SBSRATM.Models.Aeps;
import com.tech4lyf.SBSRATM.Models.Card;
import com.tech4lyf.SBSRATM.Models.CyberPlat;
import com.tech4lyf.SBSRATM.Models.DMT;
import com.tech4lyf.SBSRATM.Models.Mswipe;
import com.tech4lyf.SBSRATM.ViewModels.AepsViewModel;
import com.tech4lyf.SBSRATM.ViewModels.CardViewModel;
import com.tech4lyf.SBSRATM.ViewModels.CyberPlatViewModel;
import com.tech4lyf.SBSRATM.ViewModels.DMTViewModel;
import com.tech4lyf.SBSRATM.ViewModels.MswipeViewModel;

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
    private List<CyberPlat> cyberPlatList;
    private List<Card> cardList;
    private List<Aeps> aepsList;
    private List<Mswipe> mswipeList;
    private List<DMT> dmtList;
    private RecyclerViewAdapterCyberPlat recyclerViewAdapterCyberPlat;
    private RecyclerViewAdapterCard recyclerViewAdapterCard;
    private RecyclerViewAdapterAeps recyclerViewAdapterAeps;
    private RecyclerViewAdapterMswipe recyclerViewAdapterMswipe;
    private RecyclerViewAdapterDMT recyclerViewAdapterDMT;
    private CyberPlatViewModel cyberPlatViewModel;
    private CardViewModel cardViewModel;
    private AepsViewModel aepsViewModel;
    private MswipeViewModel mswipeViewModel;
    private DMTViewModel dmtViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        cyberPlatList = new ArrayList<>();
        cardList = new ArrayList<>();
        aepsList = new ArrayList<>();
        mswipeList = new ArrayList<>();
        dmtList = new ArrayList<>();


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

                    for (CyberPlat cyberPlat : cyberPlatList) {
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
                } else if (type.equals("CARD")) {
                    List<Card> cardsSearch = new ArrayList<Card>(Arrays.asList(new Card[0]));
                    for (Card card : cardList) {
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
                    recyclerViewAdapterCyberPlat.setCyberPlats(cyberPlatList);
                    recyclerViewAdapterCyberPlat.notifyDataSetChanged();
                } else if (type.equals("CARD")) {
                    recyclerViewAdapterCard.setCards(cardList);
                    recyclerViewAdapterCard.notifyDataSetChanged();

                }

            }
        });


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
            recyclerViewAdapterCyberPlat = new RecyclerViewAdapterCyberPlat(cyberPlatList, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterCyberPlat);
            cyberPlatViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(CyberPlatViewModel.class);
            cyberPlatViewModel.getCyberPlats().observe(RecyclerViewActivity.this, new Observer<List<CyberPlat>>() {
                @Override
                public void onChanged(List<CyberPlat> cyberPlats) {
                    cyberPlatList = cyberPlats;
                    Collections.reverse(cyberPlatList);
                    recyclerViewAdapterCyberPlat.setCyberPlats(cyberPlatList);
                    recyclerViewAdapterCyberPlat.notifyDataSetChanged();

                }
            });

        } else if (type.equals("CARD")) {
            recyclerViewAdapterCard = new RecyclerViewAdapterCard(cardList, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterCard);
            cardViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(CardViewModel.class);
            cardViewModel.getCards().observe(RecyclerViewActivity.this, new Observer<List<Card>>() {
                @Override
                public void onChanged(List<Card> cards) {
                    cardList = cards;
                    Collections.reverse(cardList);
                    recyclerViewAdapterCard.setCards(cardList);
                    recyclerViewAdapterCard.notifyDataSetChanged();

                }
            });


        } else if (type.equals("AEPS")) {
            recyclerViewAdapterAeps = new RecyclerViewAdapterAeps(aepsList, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterAeps);
            aepsViewModel = ViewModelProviders.of(RecyclerViewActivity.this).get(AepsViewModel.class);
            aepsViewModel.getAepss().observe(RecyclerViewActivity.this, new Observer<List<Aeps>>() {
                @Override
                public void onChanged(List<Aeps> aepss) {
                    aepsList = aepss;
                    Collections.reverse(aepsList);
                    recyclerViewAdapterAeps.setAepss(aepss);
                    recyclerViewAdapterAeps.notifyDataSetChanged();

                }
            });


        } else if (type.equals("MSWIPE")) {
            recyclerViewAdapterMswipe = new RecyclerViewAdapterMswipe(mswipeList, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterMswipe);
            mswipeViewModel = new ViewModelProvider(getViewModelStore(), getDefaultViewModelProviderFactory()).get(MswipeViewModel.class);
            mswipeViewModel.getmSwipes().observe(RecyclerViewActivity.this, new Observer<List<Mswipe>>() {
                @Override
                public void onChanged(List<Mswipe> mswipes) {
                    mswipeList = mswipes;
                    Collections.reverse(mswipeList);
                    recyclerViewAdapterMswipe.setMswipes(mswipes);
                    recyclerViewAdapterMswipe.notifyDataSetChanged();

                }
            });


        } else if (type.equals("DMT")) {
            recyclerViewAdapterDMT = new RecyclerViewAdapterDMT(dmtList, RecyclerViewActivity.this);
            recyclerView.setAdapter(recyclerViewAdapterDMT);
            dmtViewModel = new ViewModelProvider(getViewModelStore(), getDefaultViewModelProviderFactory()).get(DMTViewModel.class);
            dmtViewModel.getdmts().observe(RecyclerViewActivity.this, new Observer<List<DMT>>() {
                @Override
                public void onChanged(List<DMT> dmts) {
                    dmtList = dmts;
                    Collections.reverse(dmtList);
                    recyclerViewAdapterDMT.setDmts(dmts);
                    recyclerViewAdapterDMT.notifyDataSetChanged();

                }
            });


        }


    }
}
