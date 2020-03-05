package com.example.weather.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://restcountries.eu/rest/";
    public static final String BASE_URL2 = "https://restcountries.eu/rest/";

    private static Retrofit retrofit1 = null;
    private static Retrofit retrofit2 = null;

    public static Retrofit getClient () {
        if (retrofit1==null){
            retrofit1 = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit1;
    }

    public static Retrofit getClient2 () {
        if (retrofit2==null){
            retrofit2 = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit2;
    }
}
