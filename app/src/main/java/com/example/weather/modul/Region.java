package com.example.weather.modul;

import android.os.Parcel;
import android.os.Parcelable;

public class Region implements Parcelable {
    private String name;
    private int some;

    public Region(String name, int some) {
        this.name = name;
        this.some = some;
    }

    protected Region(Parcel in) {
        name = in.readString();
        some = in.readInt();
    }

    public static final Creator<Region> CREATOR = new Creator<Region>() {
        @Override
        public Region createFromParcel(Parcel in) {
            return new Region(in);
        }

        @Override
        public Region[] newArray(int size) {
            return new Region[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSome() {
        return some;
    }

    public void setSome(int some) {
        this.some = some;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(some);
    }
}

