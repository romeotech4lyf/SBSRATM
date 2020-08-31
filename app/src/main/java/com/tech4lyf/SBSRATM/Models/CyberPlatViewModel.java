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

public class CyberPlatViewModel extends AndroidViewModel {

    private MutableLiveData<List<CyberPlat>> cyberPlats;
    private List<CyberPlat> cyberPlatsList = new ArrayList<CyberPlat>(Arrays.asList(new CyberPlat[0]));

    public CyberPlatViewModel(@NonNull Application application) {
        super(application);
        cyberPlats = new MutableLiveData<>(cyberPlatsList);
        cyberPlats.setValue(cyberPlatsList);
        getCyberPlat();
    }
    JSONArray jsonArray = new JSONArray();

    private void getCyberPlat() {


            final String urlString = "https://developers.tech4lyf.com/romeotamizh/sbsr/CyberPlatCashTransfer.php";
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
                                    CyberPlat cyberPlat;
                                    cyberPlat = gson.fromJson(jsonObject.toString(), CyberPlat.class);
                                    cyberPlatsList.add(cyberPlat);
                                    cyberPlats.postValue(cyberPlatsList);

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

    public MutableLiveData<List<CyberPlat>> getCyberPlats() {
        return cyberPlats;
    }
}
