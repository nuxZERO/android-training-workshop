package me.cafecode.android.workshop.models;

import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("lat")
    private double latitude;

    @SerializedName("lng")
    private double longitude;

    public Location() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

}
