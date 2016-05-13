package me.cafecode.android.workshop.models;

public class DetailsResponse {

    private String status;

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
