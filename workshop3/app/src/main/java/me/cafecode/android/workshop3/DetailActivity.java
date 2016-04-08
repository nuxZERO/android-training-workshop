package me.cafecode.android.workshop3;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Locale;

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

        // Get intent data
        @DrawableRes int photo = getIntent().getIntExtra("photo", -1);
        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        double rating = getIntent().getDoubleExtra("rating", -1);
        String review = getIntent().getStringExtra("review");

        // TODO: 19 - Get parcel object from intent

        // Bind data and views
        photoImage.setImageResource(photo);
        nameText.setText(name);
        addressText.setText(address);
        ratingText.setText(String.format(Locale.getDefault(), "%.1f", rating));
        reviewText.setText(review);
        ratingBar.setRating((float) rating);

        // TODO: 20 - Bind views with place object

    }

}
