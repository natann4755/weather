package com.example.weather.Retrofit;


import com.example.weather.modul.Contry;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterpafe {


    @GET("region/{reg}")
    Call<Contry[]> getContryRegion (@Path("reg")String region);

    @GET("v2/")
    Call<Contry[]> getAllContry();
//
//    @GET()
//    Call<Contry[]> getWether();

}
