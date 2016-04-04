package me.cafecode.android.workshop3.models;

import android.support.annotation.DrawableRes;

import java.util.List;

/**
 * Created by Natthawut Hemathulin on 8/8/15 AD.
 * Email: natthawut1991@gmail.com
 */
public class Place {

    private String id = "";
    private String name = "";
    private String address = "";
    private double rating = 0.0;
    private @DrawableRes int photo;
    private String review;

    // Advance
    private Geometry geometry;
    private String phone = "";
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

    public Place(String id, String name, String address, double rating, Geometry geometry, String phone, List<Photo> photos, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.geometry = geometry;
        this.phone = phone;
        this.photos = photos;
        this.reviews = reviews;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
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
