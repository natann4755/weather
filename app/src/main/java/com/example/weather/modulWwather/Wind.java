package com.example.weather.modulWwather;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Wind implements Parcelable {

	@SerializedName("deg")
	private int deg;

	@SerializedName("speed")
	private double speed;

	protected Wind(Parcel in) {
		deg = in.readInt();
		speed = in.readDouble();
	}

	public static final Creator<Wind> CREATOR = new Creator<Wind>() {
		@Override
		public Wind createFromParcel(Parcel in) {
			return new Wind(in);
		}

		@Override
		public Wind[] newArray(int size) {
			return new Wind[size];
		}
	};

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(deg);
		dest.writeDouble(speed);
	}
}