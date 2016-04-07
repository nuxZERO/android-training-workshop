package me.cafecode.android.workshop3.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.cafecode.android.workshop3.DetailActivity;
import me.cafecode.android.workshop3.R;
import me.cafecode.android.workshop3.models.Place;

/**
 * Created by Natthawut Hemathulin on 4/5/16 AD.
 * Email: natthawut1991@gmail.com
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private List<Place> places;
    private Context context;

    public PlaceAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.adapter_place, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        final Place place = places.get(position);
        // TODO: Bind view
        holder.photoImage.setImageResource(place.getPhoto());
        holder.nameText.setText(place.getName());
        holder.ratingText.setText(Double.toString(place.getRating()));
        holder.addressText.setText(place.getAddress());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlaceDetailActivity(place);
            }
        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    private void startPlaceDetailActivity(Place place) {
        Intent placeIntent = new Intent(context, DetailActivity.class);
        placeIntent.putExtra("photo", place.getPhoto());
        placeIntent.putExtra("name", place.getName());
        placeIntent.putExtra("rating", place.getRating());
        placeIntent.putExtra("address", place.getAddress());
        placeIntent.putExtra("review", place.getReview());
        context.startActivity(placeIntent);
    }

}
