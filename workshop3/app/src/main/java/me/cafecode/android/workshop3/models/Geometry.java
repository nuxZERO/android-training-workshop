package me.cafecode.android.workshop3.models;

/**
 * Created by Natthawut Hemathulin on 4/4/16 AD.
 * Email: natthawut1991@gmail.com
 */
public class Geometry {

    private Location location;

    public Geometry() {
    }

    public Geometry(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
