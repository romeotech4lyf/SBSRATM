package com.tech4lyf.SBSRATM.Models;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardViewModel extends AndroidViewModel {

    private MutableLiveData<List<Card>> cards;
    private List<Card> cardsList = new ArrayList<Card>(Arrays.asList(new Card[0]));

    public CardViewModel(@NonNull Application application) {
        super(application);
        cards = new MutableLiveData<>(cardsList);
        cards.setValue(cardsList);
        getCard();
    }
    JSONArray jsonArray = new JSONArray();

    private void getCard() {


        final String urlString = "https://developers.tech4lyf.com/romeotamizh/sbsr/tblCardWithdraw.php";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = null;
                    try {
                        url = new URL(urlString);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
                    httpcon.addRequestProperty("User-Agent", "Mozilla/4.76");
                    InputStreamReader reader = new InputStreamReader(httpcon.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    //Log.d("post", bufferedReader.readLine());
                    reader.getEncoding();
                    String str;

                    if ((str = bufferedReader.readLine())!=null) {
                        try {
                            String st = str.substring(8,str.length()-1);
                            jsonArray = new JSONArray(st);
                            for(int i = 0; i< jsonArray.length();i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Gson gson = new Gson();
                                Card card;
                                card = gson.fromJson(jsonObject.toString(), Card.class);
                                cardsList.add(card);
                                cards.postValue(cardsList);

                                Log.d("post", st);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }


            }
        }).start();


    }

    public MutableLiveData<List<Card>> getCards() {
        return cards;
    }
}
