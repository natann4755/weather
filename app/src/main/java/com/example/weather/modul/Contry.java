package com.example.weather.modul;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Contry implements Parcelable{

    @SerializedName("name")
    private String name;

    @SerializedName("region")
    private String region;

    @SerializedName("latlng")
    private List<Double> latlng;

    @SerializedName("flag")
    private String flag;

    private boolean favorite = false;



    public Contry(String name, String region, List<Double> latlng, String flag) {
        this.name = name;
        this.region = region;
        this.latlng = latlng;
        this.flag = flag;
    }

    protected Contry(Parcel in) {
        name = in.readString();
        region = in.readString();
        flag = in.readString();
    }


    public static final Creator<Contry> CREATOR = new Creator<Contry>() {
        @Override
        public Contry createFromParcel(Parcel in) {
            return new Contry(in);
        }

        @Override
        public Contry[] newArray(int size) {
            return new Contry[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List  getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Double> latlng) {
        this.latlng = latlng;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(region);
        dest.writeString(flag);
        dest.writeByte((byte) (favorite ? 1 : 0));
    }
}
//43.000000, -75.000000