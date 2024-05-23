package com.omerpanay.anew.fromAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {

    @Headers({
            "X-RapidAPI-Key: e47ffc5c8bmsh5af8a8647f7646ep1709f9jsn1cae0a77ecd3",
            "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com"
    })
    @GET("search")
    Call<MyData> getData(@Query("q") String query);



}
