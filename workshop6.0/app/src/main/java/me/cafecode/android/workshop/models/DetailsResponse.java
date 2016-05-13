package me.cafecode.android.workshop.models;

import com.google.gson.annotations.SerializedName;

public class DetailsResponse {

    private String status;

    @SerializedName("result")
    private Place place;

    public DetailsResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
