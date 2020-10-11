package com.tech4lyf.SBSRATM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DashBoardActivity extends AppCompatActivity implements View.OnClickListener {
    private CircleImageView dp;
    private TextView name;
    private TextView bcid;
    private TextView atmId;
    private TextView locationId;
    private TextView cashInDispenser;
    private TextView cashInAcceptor;
    private TextView cashInAtm;
    private TextView totalTransaction;
    private TextView cyber_plat;
    private TextView card;
    private TextView aeps;
    private TextView bbps;
    private TextView wallet;
    private TextView fastTag;
    private CardView dashBoardCyberPlat;
    private CardView dashBoardCard;
    private CardView dashBoardAeps;
    private CardView dashBoardMSwipe;
    private CardView dashBoardWallet;
    private CardView dashBoardDMT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //initializeViews
        dp = findViewById(R.id.activity_dash_board_dp);
        name = findViewById(R.id.activity_dash_board_name);
        bcid = findViewById(R.id.activity_dash_board_bcid);
        atmId = findViewById(R.id.activity_dash_board_atm_id);
        locationId = findViewById(R.id.activity_dash_board_location_id);
        cashInDispenser = findViewById(R.id.activity_dash_board_cash_in_dispenser);
        cashInAcceptor = findViewById(R.id.activity_dash_board_cash_in_acceptor);
        cashInAtm = findViewById(R.id.activity_dash_board_cash_in_atm);
        totalTransaction = findViewById(R.id.activity_dash_board_total_transaction);
        cyber_plat = findViewById(R.id.activity_dash_board_cyber_plat);
        card = findViewById(R.id.activity_dash_board_card);
        aeps = findViewById(R.id.activity_dash_board_aeps);
        bbps = findViewById(R.id.activity_dash_board_mswipe);
        wallet = findViewById(R.id.activity_dash_board_wallet);
        fastTag = findViewById(R.id.activity_dash_board_dmt);
        dashBoardCyberPlat = findViewById(R.id.activity_dash_board_dashboard_cyber_plat);
        dashBoardCard = findViewById(R.id.activity_dash_board_dashboard_card);
        dashBoardAeps = findViewById(R.id.activity_dash_board_dashboard_aeps);
        dashBoardMSwipe = findViewById(R.id.activity_dash_board_dashboard_mswipe);
        dashBoardWallet = findViewById(R.id.activity_dash_board_dashboard_wallet);
        dashBoardDMT = findViewById(R.id.activity_dash_board_dashboard_dmt);

        dashBoardCyberPlat.setOnClickListener(this);
        dashBoardCard.setOnClickListener(this);
        dashBoardAeps.setOnClickListener(this);
        dashBoardMSwipe.setOnClickListener(this);
        dashBoardDMT.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_dash_board_dashboard_cyber_plat:
                startRecyclerViewActivity("CYBERPLAT");
                break;
            case R.id.activity_dash_board_dashboard_card:
                startRecyclerViewActivity("CARD");
                break;
            case R.id.activity_dash_board_dashboard_aeps:
                startRecyclerViewActivity("AEPS");
                break;
            case R.id.activity_dash_board_dashboard_mswipe:
                startRecyclerViewActivity("MSWIPE");
                break;
            case R.id.activity_dash_board_dashboard_dmt:
                startRecyclerViewActivity("DMT");
                break;
            case R.id.activity_dash_board_dashboard_wallet:
                break;
            default:
                break;
        }
    }

    private void startRecyclerViewActivity(String type) {
        DashBoardActivity.this
                .startActivity(new Intent(DashBoardActivity.this, RecyclerViewActivity.class).putExtra("TYPE", type));
    }
}
