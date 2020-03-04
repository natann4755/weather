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
    private ArrayList<Contry> contreyOceania=new ArrayList<>();
    private ArrayList<Contry> contreyAntartica=new ArrayList<>();
    private ArrayList<Contry> Isolatedislands=new ArrayList<>();



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
        myArreyRegion.add(new Region("All Contrey",AllContrey.size(),
                "https://www.rm-style.com/wp-content/uploads/2018/06/colore-nel-mondo.jpg"));
        myArreyRegion.add(new Region("Africa",contreyAfrica.size(),
                "https://thumbs.dreamstime.com/b/multicolored-political-map-africa-continent-national-borders-country-name-labels-white-background-vector-94885761.jpg"));
        myArreyRegion.add(new Region("Asia",contreyAsia.size(),"https://www.ibu.edu.ba/assets/userfiles/ires/south_asia.jpg"));
        myArreyRegion.add(new Region("Americas",contreyAmericas.size(),"https://as2.ftcdn.net/jpg/01/59/55/63/500_F_159556388_c789nxJi54oxoJxnXJFtBsZLJclJ3CFW.jpg"));
        myArreyRegion.add(new Region("Europe",contreyEurope.size(),"https://image.freepik.com/free-vector/colorful-map-europe_23-2147807669.jpg"));
        myArreyRegion.add(new Region("Oceania",contreyOceania.size(),"https://images.assetsdelivery.com/compings_v2/noche/noche1702/noche170200043.jpg"));
        myArreyRegion.add(new Region("Polar",contreyAntartica.size(),"https://image.shutterstock.com/image-vector/antarctica-map-260nw-521073739.jpg"));
        myArreyRegion.add(new Region("Isolated islands",Isolatedislands.size(),"https://media.istockphoto.com/vectors/marshall-islands-map-black-outline-with-shadow-on-white-background-vector-id1127289481"));

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
                case "Oceania":
                    contreyOceania.add(contry);
                    break;
                case "Polar":
                    contreyAntartica.add(contry);
                    break;

                default:
                   Isolatedislands.add(contry);
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
            case "Oceania":
                fragmentListContrey(contreyOceania);
                break;
            case "Polar":
                fragmentListContrey(contreyAntartica);
                break;

            default:
                fragmentListContrey(Isolatedislands);

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

    @Override
    public void onContreyClick(Contry contry) {
        Contry c = contry;
    }
}
