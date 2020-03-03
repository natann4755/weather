package com.example.weather.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weather.Fragments.FragmentContreys;
import com.example.weather.Fragments.FragmentsRegion;
import com.example.weather.R;
import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterpafe;
import com.example.weather.modul.Contry;
import com.example.weather.modul.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityAllContreys extends AppCompatActivity implements FragmentsRegion.OnFragmentAllContreysListener, FragmentContreys.OnFragmentContreysListener {

    private List<Contry> myContryes;
    private List<Region> myArreyRegion = new ArrayList<>();

    private ArrayList<Contry> AllContrey=new ArrayList<>();
    private ArrayList<Contry> contreyAfrica=new ArrayList<>();
    private ArrayList<Contry> contreyAsia=new ArrayList<>();
    private ArrayList<Contry> contreyAmericas=new ArrayList<>();
    private ArrayList<Contry> contreyEurope=new ArrayList<>();
    private ArrayList<Contry> otherContrey=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acyivity_all_contreys);

        getContrey();



    }
    private void getContrey() {
        ApiInterpafe mApiInterpafe = ApiClient.getClient().create(ApiInterpafe.class);

        Call<Contry[]> call = mApiInterpafe.getAllContry();
        call.enqueue(new Callback<Contry[]>() {
            @Override
            public void onResponse(Call<Contry[]> call, Response<Contry[]> response) {
                Contry[] arreyContres = response.body();
                myContryes = new ArrayList<>(Arrays.asList(arreyContres));
                initAreeyRegion();
                initFramlayot();
            }

            @Override
            public void onFailure(Call<Contry[]> call, Throwable t) {

            }
        });
    }




    private void initFramlayot() {
        FragmentsRegion mFragmentsRegion = FragmentsRegion.newInstance(myArreyRegion);
        getSupportFragmentManager().beginTransaction().replace(R.id.A2AllContreyFL, mFragmentsRegion).commit();
    }



    private void initAreeyRegion() {

        sumConyrey();
        myArreyRegion.add(new Region("All Contrey",AllContrey.size()));
        myArreyRegion.add(new Region("Africa",contreyAfrica.size()));
        myArreyRegion.add(new Region("Asia",contreyAsia.size()));
        myArreyRegion.add(new Region("Americas",contreyAmericas.size()));
        myArreyRegion.add(new Region("Europe",contreyEurope.size()));
        myArreyRegion.add(new Region("Other",otherContrey.size()));

    }

    private void sumConyrey() {
        AllContrey.addAll(myContryes);
        for (Contry contry : myContryes) {
            switch(contry.getRegion()) {
                case "Africa":
                    contreyAfrica.add(contry);
                    break;
                case "Asia":
                    contreyAsia.add(contry);
                    break;
                case "Americas":
                    contreyAmericas.add(contry);
                    break;
                case "Europe":
                    contreyEurope.add(contry);
                    break;

                default:
                    otherContrey.add(contry);
            }

        }

    }






    @Override
    public void onFragmentAllContreys() {

    }

    @Override
    public void onContreysClick(String ringName) {
        switch(ringName) {
            case "All Contrey":
                fragmentListContrey(AllContrey);
                break;
            case "Africa":
                fragmentListContrey(contreyAfrica);
                break;
            case "Asia":
                fragmentListContrey(contreyAsia);
                break;
            case "Americas":
                fragmentListContrey(contreyAmericas);
                break;
            case "Europe":
                fragmentListContrey(contreyEurope);
                break;
            case "Other":
                fragmentListContrey(otherContrey);
                break;
        }

    }

    private void fragmentListContrey(ArrayList<Contry> contreys) {
        FragmentContreys mFragmentContreys = FragmentContreys.newInstance(contreys);
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null).replace(R.id.A2AllContreyFL, mFragmentContreys).commit();


    }


    @Override
    public void onFragmentContreys() {

    }
}
