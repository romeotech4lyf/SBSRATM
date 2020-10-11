package com.tech4lyf.SBSRATM.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.tech4lyf.SBSRATM.Models.Mswipe;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MswipeViewModel extends AndroidViewModel {
    JSONArray jsonArray;
    private MutableLiveData<List<Mswipe>> mSwipes;
    private List<Mswipe> mSwipesList = new ArrayList<>(Collections.<Mswipe>emptyList());

    public MswipeViewModel(@NonNull Application application) {
        super(application);
        mSwipes = new MutableLiveData<>(mSwipesList);
        mSwipes.setValue(mSwipesList);
        getMSwipesList();
    }

    public MutableLiveData<List<Mswipe>> getmSwipes() {
        return mSwipes;
    }

    private void getMSwipesList() {
        final String urlString = "https://sbsrkannam.com/dashboard/DbMswipe.php";

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

                    String jsonArrayWithExtras;

                    if ((jsonArrayWithExtras = bufferedReader.readLine()) != null) {
                        String jsonArrayOnly = jsonArrayWithExtras.substring(jsonArrayWithExtras.indexOf("["), jsonArrayWithExtras.indexOf("]") + 1);
                        jsonArray = new JSONArray(jsonArrayOnly);
                        for (int i = 0; i < jsonArray.length(); i++)
                            if (mSwipesList.add( new Gson().fromJson(jsonArray.getJSONObject(i).toString(),Mswipe.class)))
                                mSwipes.postValue(mSwipesList);

                    }
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


}
