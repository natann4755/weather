package com.example.weather.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.weather.R;
import com.example.weather.Retrofit.ApiClient;
import com.example.weather.Retrofit.ApiInterpafe;
import com.example.weather.modulWwather.Main;
import com.example.weather.modulWwather.Responsee;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList  mContry;
    public static final String apikeyWeather = "2278f04dd5ede897f90362371419d187";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mContry =  getIntent().getParcelableArrayListExtra(ActivityAllContreys.keycontrey);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        Double one = (Double) mContry.get(0);
        Double to = (Double) mContry.get(1);
        LatLng sydney = new LatLng(one,to);
        mMap.setMinZoomPreference(8f);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(getApplicationContext(),String.valueOf(latLng.latitude+"   "+latLng.longitude),
                        Toast.LENGTH_LONG).show();
                getWeather(latLng.latitude,latLng.longitude);
            }
        });


//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }

    private void getWeather(Double latitude, Double longitude) {
        ApiInterpafe mApiInterpafe = ApiClient.getClient2().create(ApiInterpafe.class);
        Call <Responsee> call = mApiInterpafe.getWetherPointsTest2(latitude,longitude);
        call.enqueue(new Callback<Responsee>() {
            @Override
            public void onResponse(Call<Responsee> call, Response<Responsee> response) {
                Toast.makeText(getApplicationContext(),String.valueOf(response.body().getMain().getTemp()+" "+response.body().getWeather().get(0).getDescription()),
                        Toast.LENGTH_LONG).show();

//                AlertDialog.Builder builder1 = new AlertDialog.Builder(getBaseContext());
//                builder1.setMessage("Write your message here.");
//                builder1.setCancelable(true);
//
//                AlertDialog alert11 = builder1.create();
//                alert11.show();


                new AlertDialog.Builder(getBaseContext())
                .setTitle("Alert")
                .setMessage("Alert message to be shown").create().show();
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                alertDialog.show();
            }

            @Override
            public void onFailure(Call<Responsee> call, Throwable t) {

            }
        });

    }
}
