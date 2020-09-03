package com.lfj.selfstudydemo.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class LatLng implements Parcelable {
    public double latitude;
    public double longitude;

    public LatLng(double lat, double lng) {
        this.latitude=lat;
        this.longitude=lng;
    }

    protected LatLng(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    public static final Creator<LatLng> CREATOR = new Creator<LatLng>() {
        @Override
        public LatLng createFromParcel(Parcel in) {
            return new LatLng(in);
        }

        @Override
        public LatLng[] newArray(int size) {
            return new LatLng[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }
}
