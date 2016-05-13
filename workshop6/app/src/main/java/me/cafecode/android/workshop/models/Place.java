package me.cafecode.android.workshop.models;

import android.support.annotation.DrawableRes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Place {

    @SerializedName("place_id")
    private String id = "";

    private String name = "";

    @SerializedName("formatted_address")
    private String address = "";

    private String vicinity = "";

    private Geometry geometry;

    private double rating = 0.0;
    private @DrawableRes int photo;
    private String review;

    private List<Photo> photos;
    private List<Review> reviews;

    public Place() {

    }

    public Place(String name, String address, double rating, @DrawableRes int photo, String review) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.photo = photo;
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
