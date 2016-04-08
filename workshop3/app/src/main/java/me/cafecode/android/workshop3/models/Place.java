package me.cafecode.android.workshop3.models;

import android.support.annotation.DrawableRes;

/**
 * Created by Natthawut Hemathulin on 8/8/15 AD.
 * Email: natthawut1991@gmail.com
 */
// TODO: 18 - Implement Parcelable
public class Place {

    private String id = "";
    private String name = "";
    private String address = "";
    private double rating = 0.0;
    private @DrawableRes int photo;
    private String review;

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

}
