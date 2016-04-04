package me.cafecode.android.workshop3.models;

/**
 * Created by Natthawut Hemathulin on 4/4/16 AD.
 * Email: natthawut1991@gmail.com
 */
public class Photo {
    private String photoReference = "";
    private int height = 0;
    private int width = 0;

    public Photo() {
    }

    public Photo(String photoReference, int height, int width) {
        this.photoReference = photoReference;
        this.height = height;
        this.width = width;
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
