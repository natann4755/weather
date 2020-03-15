package com.example.weather.modulWwather;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Wind  {

	@SerializedName("deg")
	private int deg;

	@SerializedName("speed")
	private double speed;





	public void setDeg(int deg){
		this.deg = deg;
	}

	public int getDeg(){
		return deg;
	}

	public void setSpeed(double speed){
		this.speed = speed;
	}

	public double getSpeed(){
		return speed;
	}

	@Override
 	public String toString(){
		return 
			"Wind{" + 
			"deg = '" + deg + '\'' + 
			",speed = '" + speed + '\'' + 
			"}";
		}


}