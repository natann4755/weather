package com.example.weather.modulWwather;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Sys implements Parcelable {

	@SerializedName("country")
	private String country;

	@SerializedName("sunrise")
	private int sunrise;

	@SerializedName("sunset")
	private int sunset;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private int type;

	@SerializedName("message")
	private double message;

	protected Sys(Parcel in) {
		country = in.readString();
		sunrise = in.readInt();
		sunset = in.readInt();
		id = in.readInt();
		type = in.readInt();
		message = in.readDouble();
	}

	public static final Creator<Sys> CREATOR = new Creator<Sys>() {
		@Override
		public Sys createFromParcel(Parcel in) {
			return new Sys(in);
		}

		@Override
		public Sys[] newArray(int size) {
			return new Sys[size];
		}
	};

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setSunrise(int sunrise){
		this.sunrise = sunrise;
	}

	public int getSunrise(){
		return sunrise;
	}

	public void setSunset(int sunset){
		this.sunset = sunset;
	}

	public int getSunset(){
		return sunset;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setMessage(double message){
		this.message = message;
	}

	public double getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"Sys{" + 
			"country = '" + country + '\'' + 
			",sunrise = '" + sunrise + '\'' + 
			",sunset = '" + sunset + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(country);
		dest.writeInt(sunrise);
		dest.writeInt(sunset);
		dest.writeInt(id);
		dest.writeInt(type);
		dest.writeDouble(message);
	}
}