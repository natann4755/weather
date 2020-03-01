package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weather.modul.Contry;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Contry> myContryes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContrey("Asia");
    }

    private void getContrey(final String region) {
        ApiInterpafe mApiInterpafe = ApiClient.getClient().create(ApiInterpafe.class);

        Call<Contry[]> call = mApiInterpafe.getContryRegion(region);
        call.enqueue(new Callback<Contry[]>() {
            @Override
            public void onResponse(Call<Contry[]> call, Response<Contry[]> response) {
                Contry[] arreyContres = response.body();
                myContryes = new ArrayList<>(Arrays.asList(arreyContres));



            }

            @Override
            public void onFailure(Call<Contry[]> call, Throwable t) {

            }
        });
    }
}
