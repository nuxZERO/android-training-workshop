package me.cafecode.android.workshop.models;

import com.google.gson.annotations.SerializedName;

public class Review {

    @SerializedName("author_name")
    private String authorName;

    @SerializedName("author_url")
    private String authorUrl;

    @SerializedName("profile_photo_url")
    private String profilePhotoUrl;

    private double rating;

    private String text;

    public Review() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
