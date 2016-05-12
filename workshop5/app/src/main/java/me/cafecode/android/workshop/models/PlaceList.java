package me.cafecode.android.workshop.models;

import java.util.ArrayList;
import java.util.List;

import me.cafecode.android.workshop.R;

/**
 * Created by Natthawut Hemathulin on 5/10/16 AD.
 * Email: natthawut1991@gmail.com
 */
public class PlaceList {

    public static List<Place> getPlaceList() {
        List<Place> places = new ArrayList<>();

        Place place1 = new Place("Novotel Sydney on Darling Harbour",
                "100 Murray Street, Pyrmont",
                3.2,
                R.drawable.place1,
                "Located on a side street from the bustling thoroughfare of Crows Nest (Willoughby Rd), this place is huge compared to the neighbouring restaurants. During Summer when the weather is nice, you will find tables encroaching onto the sidewalk and is a local favourite. \n\nFood-wise, you will find some traditional greek staples alongside some modern dishes. Definitely brings me back to the last time I was hopping around the Greek Islands. \n\nService is average. As it is a popular place, sometimes it can be hard to get a hold of a waiter/waitress. This is not to say that service is generally poor. Just non-memorable. \n\nFor a meal here, you would be expected to pay Crows Nest prices. Which is to say slightly above the average meal in Sydney. Not outrageous by any means, and to be fair is quite reasonable for the area.");
        places.add(place1);

        Place place2 = new Place("Travelodge Wynyard",
                "22 Shelley Street, King Street Wharf, Sydney",
                2.9,
                R.drawable.place2,
                "Located on a side street from the bustling thoroughfare of Crows Nest (Willoughby Rd), this place is huge compared to the neighbouring restaurants. During Summer when the weather is nice, you will find tables encroaching onto the sidewalk and is a local favourite. \n\nFood-wise, you will find some traditional greek staples alongside some modern dishes. Definitely brings me back to the last time I was hopping around the Greek Islands. \n\nService is average. As it is a popular place, sometimes it can be hard to get a hold of a waiter/waitress. This is not to say that service is generally poor. Just non-memorable. \n\nFor a meal here, you would be expected to pay Crows Nest prices. Which is to say slightly above the average meal in Sydney. Not outrageous by any means, and to be fair is quite reasonable for the area.");
        places.add(place2);

        Place place3 = new Place("The Menzies Sydney",
                "7-9 York Street, Sydney",
                3.2,
                R.drawable.place3,
                "Located on a side street from the bustling thoroughfare of Crows Nest (Willoughby Rd), this place is huge compared to the neighbouring restaurants. During Summer when the weather is nice, you will find tables encroaching onto the sidewalk and is a local favourite. \n\nFood-wise, you will find some traditional greek staples alongside some modern dishes. Definitely brings me back to the last time I was hopping around the Greek Islands. \n\nService is average. As it is a popular place, sometimes it can be hard to get a hold of a waiter/waitress. This is not to say that service is generally poor. Just non-memorable. \n\nFor a meal here, you would be expected to pay Crows Nest prices. Which is to say slightly above the average meal in Sydney. Not outrageous by any means, and to be fair is quite reasonable for the area.");
        places.add(place3);

        Place place4 = new Place("Base Backpackers Sydney",
                "14 Carrington Street, Sydney",
                4.5,
                R.drawable.place4,
                "Located on a side street from the bustling thoroughfare of Crows Nest (Willoughby Rd), this place is huge compared to the neighbouring restaurants. During Summer when the weather is nice, you will find tables encroaching onto the sidewalk and is a local favourite. \n\nFood-wise, you will find some traditional greek staples alongside some modern dishes. Definitely brings me back to the last time I was hopping around the Greek Islands. \n\nService is average. As it is a popular place, sometimes it can be hard to get a hold of a waiter/waitress. This is not to say that service is generally poor. Just non-memorable. \n\nFor a meal here, you would be expected to pay Crows Nest prices. Which is to say slightly above the average meal in Sydney. Not outrageous by any means, and to be fair is quite reasonable for the area.");
        places.add(place4);

        return places;

    }

}
