package com.example.weather.Retrofit;


import com.example.weather.modul.Contry;
import com.example.weather.modulWwather.Responsee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterpafe {


    @GET("region/{reg}")
    Call<Contry[]> getContryRegion (@Path("reg")String region);

    @GET("v2/")
    Call<Contry[]> getAllContry();




//    @GET("weather?lat={longLat}&lon={longlon}&appid=2278f04dd5ede897f90362371419d187")
//    Call<Responsee> getWetherPoints(@Path("longLat") Double lat, @Path("longlon") Double lon);

    @GET("weather?lat=33.11797813522838&lon=65.36028753966093")
    Call<Responsee> getWetherPointsTest(@Query("appid") String apiKey);

}
