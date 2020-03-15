package com.example.weather.modulWwather;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Clouds {

	@SerializedName("all")
	private int all;


	public void setAll(int all){
		this.all = all;
	}

	public int getAll(){
		return all;
	}

	@Override
 	public String toString(){
		return 
			"Clouds{" + 
			"all = '" + all + '\'' + 
			"}";
		}


}