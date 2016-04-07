package me.cafecode.android.workshop3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import me.cafecode.android.workshop3.adapters.PlaceAdapter;
import me.cafecode.android.workshop3.models.Place;

public class MainActivity extends AppCompatActivity {

    private List<Place> places;

    private TextView placeName1Text;
    private TextView address1Text;
    private TextView rating1Text;
    private ImageView placePhoto1Image;

    private TextView placeName2Text;
    private TextView address2Text;
    private TextView rating2Text;
    private ImageView placePhoto2Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init list of places
        places = generateData();

        // TODO: Hardcore coding
        // Place 1
        placePhoto1Image = (ImageView) findViewById(R.id.place_1_image);
        placeName1Text = (TextView) findViewById(R.id.place_1_name_text);
        address1Text = (TextView) findViewById(R.id.place_1_address_text);
        rating1Text = (TextView) findViewById(R.id.place_1_rating_text);

        Place place1 = places.get(0);
        placePhoto1Image.setImageResource(place1.getPhoto());
        placeName1Text.setText(place1.getName());
        address1Text.setText(place1.getAddress());
        rating1Text.setText(String.format(Locale.getDefault(), "%.1f", place1.getRating()));

        // Place 2
        placePhoto2Image = (ImageView) findViewById(R.id.place_2_image);
        placeName2Text = (TextView) findViewById(R.id.place_2_name_text);
        address2Text = (TextView) findViewById(R.id.place_2_address_text);
        rating2Text = (TextView) findViewById(R.id.place_2_rating_text);

        Place place2 = places.get(1);
        placePhoto2Image.setImageResource(place2.getPhoto());
        placeName2Text.setText(place2.getName());
        address2Text.setText(place2.getAddress());
        rating2Text.setText(String.format(Locale.getDefault(), "%.1f", place2.getRating()));


        placePhoto1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlaceDetailActivity(places.get(0));
            }
        });

        placePhoto2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlaceDetailActivity(places.get(1));
            }
        });

        // TODO: Get RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);

        // TODO: Set layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        // TODO: Set adapter
        PlaceAdapter adapter = new PlaceAdapter(this, places);
        recyclerView.setAdapter(adapter);

    }

    private void startPlaceDetailActivity(Place place) {
        Intent placeIntent = new Intent(this, DetailActivity.class);
        placeIntent.putExtra("photo", place.getPhoto());
        placeIntent.putExtra("name", place.getName());
        placeIntent.putExtra("rating", place.getRating());
        placeIntent.putExtra("address", place.getAddress());
        placeIntent.putExtra("review", place.getReview());
        startActivity(placeIntent);
    }

    private List<Place> generateData() {
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
