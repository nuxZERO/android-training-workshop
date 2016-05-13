package me.cafecode.android.workshop.models;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("photo_reference")
    private String photoReference;

    private int height;

    private int width;

    public Photo() {
    }

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
