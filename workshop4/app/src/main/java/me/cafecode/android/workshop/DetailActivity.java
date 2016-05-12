package me.cafecode.android.workshop;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Locale;

import me.cafecode.android.workshop.models.Place;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView photoImage = (ImageView) findViewById(R.id.place_detail_photo_image);
        TextView nameText = (TextView) findViewById(R.id.place_detail_name_text);
        TextView ratingText = (TextView) findViewById(R.id.place_detail_rating_text);
        TextView addressText = (TextView) findViewById(R.id.place_detail_address_text);
        TextView reviewText = (TextView) findViewById(R.id.place_detail_review_text);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.place_detail_rating_bar);

        // TODO: 19 - Get parcel object from intent
        Place place = getIntent().getParcelableExtra("place");

        // TODO: 20 - Bind views with place object
        photoImage.setImageResource(place.getPhoto());
        nameText.setText(place.getName());
        addressText.setText(place.getAddress());
        ratingText.setText(String.format(Locale.getDefault(), "%.1f", place.getRating()));
        reviewText.setText(place.getReview());
        ratingBar.setRating((float) place.getRating());

        // TODO: Custom ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(R.layout.action_bar);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
        }
    }

}
