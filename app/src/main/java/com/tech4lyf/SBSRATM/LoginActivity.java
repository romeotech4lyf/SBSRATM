package com.tech4lyf.SBSRATM;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText editBCID;
    private TextInputEditText editPassword;
    private CardView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editBCID = findViewById(R.id.edit_bcid);
        editPassword = findViewById(R.id.edit_password);
        signIn = findViewById(R.id.sign_in);
        signIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in:
                checkCredentials();
                break;
            default:
                break;
        }
    }

    private void checkCredentials() {
        String enteredBCID = "";
        if (editBCID.getText() != null)
            enteredBCID = editBCID.getText().toString();

        String encodedBCID = enteredBCID.replace(" ", "%20");

        String enteredPassword = "";
        if (editPassword.getText() != null)
            enteredPassword = editPassword.getText().toString();

        String encodedPassword = enteredPassword.replace(" ", "%20");

        final String urlString = "http://sbsrkannam.com/dashboard/login.php?kid=" + enteredBCID + "&password=" + encodedPassword;

        //RUDS%20-%200001
        //sbsr123!

        new Thread(new Runnable() {
            @Override
            public void run() {

                URL url = null;
                try {
                    url = new URL(urlString);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
                    InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    inputStreamReader.getEncoding();
                    String response = "";
                    if ((response = bufferedReader.readLine()) != null) {
                        Log.d("response", response);

                        if (response.contains("SUCCESS")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, DashBoardActivity.class));
                                    LoginActivity.this.finish();

                                }
                            });

                        }


                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
