package me.cafecode.android.workshop.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NearbySearchResponse {

    private String status;

    @SerializedName("next_page_token")
    private String nextPageToken;

    @SerializedName("results")
    private List<Place> places;

    public NearbySearchResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

}
