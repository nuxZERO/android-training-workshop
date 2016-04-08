package me.cafecode.android.workshop3.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;

/**
 * Created by Natthawut Hemathulin on 8/8/15 AD.
 * Email: natthawut1991@gmail.com
 */
public class Place implements Parcelable {

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

    protected Place(Parcel in) {
        id = in.readString();
        name = in.readString();
        address = in.readString();
        rating = in.readDouble();
        photo = in.readInt();
        review = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(address);
        dest.writeDouble(rating);
        dest.writeInt(photo);
        dest.writeString(review);
    }

}
