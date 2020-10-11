package com.tech4lyf.SBSRATM.ViewModels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.tech4lyf.SBSRATM.Models.Aeps;

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

public class AepsViewModel extends AndroidViewModel {

    JSONArray jsonArray = new JSONArray();
    private MutableLiveData<List<Aeps>> aepss;
    private List<Aeps> aepssList = new ArrayList<Aeps>(Arrays.asList(new Aeps[0]));

    public AepsViewModel(@NonNull Application application) {
        super(application);
        aepss = new MutableLiveData<>(aepssList);
        aepss.setValue(aepssList);
        getAeps();
    }

    private void getAeps() {

        final String urlString = "https://sbsrkannam.com/dashboard/DbAeps.php";
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

                    if ((str = bufferedReader.readLine()) != null) {
                        try {
                            String st = str.substring(str.indexOf("["),str.indexOf("]")+1);
                            jsonArray = new JSONArray(st);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Gson gson = new Gson();
                                Aeps aeps;
                                aeps = gson.fromJson(jsonObject.toString(), Aeps.class);
                                aepssList.add(aeps);
                                aepss.postValue(aepssList);

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

    public MutableLiveData<List<Aeps>> getAepss() {
        return aepss;
    }
}
