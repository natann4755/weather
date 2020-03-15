package com.example.weather.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.weather.R;
import com.example.weather.modulWwather.Responsee;

public class moreDetailsActivity extends AppCompatActivity {

    private Responsee allResponsee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);

        allResponsee = getIntent().getExtras().getParcelable(MapsActivity.keyRecponce);
    }
}
