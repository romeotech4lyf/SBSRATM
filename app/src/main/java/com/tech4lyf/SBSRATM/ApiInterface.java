package com.tech4lyf.SBSRATM;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ApiInterface {
    @GET("login.php")
    Call<User> performLogin(@Query("username") String user, @Query("password") String pass);
}
 class User {
    @SerializedName("response")
    private String Response;
    public String getResponse() {
        return Response;
    }
}
