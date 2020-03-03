package com.example.weather.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.weather.R;
import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterpafe;
import com.example.weather.modul.Contry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveToActivityContry();

//        initRV();

//        getContrey("Asia");
    }

    private void moveToActivityContry() {
        Intent goToNextActivity = new Intent(getApplicationContext(), ActivityAllContreys.class);
        startActivity(goToNextActivity);
    }




}
