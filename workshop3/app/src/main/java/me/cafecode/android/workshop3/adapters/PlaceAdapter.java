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
// TODO: 07 - Make PlaceAdapter is subclass of RecyclerView.Adapter<PlaceViewHolder>
public class PlaceAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private List<Place> mPlaces;
    private Context mContext;

    // TODO: 08 - Create constructor
    public PlaceAdapter(Context context, List<Place> places) {
        mContext = context;
        mPlaces = places;
    }

    // TODO: 09 - Create view for row from layout
    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.adapter_place, parent, false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        // TODO: 15 - Bind view
        final Place place = mPlaces.get(position);
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
        // TODO: 13 - Return number of rows in RecyclerView
        return mPlaces.size();
    }

    private void startPlaceDetailActivity(Place place) {
        // TODO: 16 - Pass data
        Intent placeIntent = new Intent(mContext, DetailActivity.class);
        placeIntent.putExtra("photo", place.getPhoto());
        placeIntent.putExtra("name", place.getName());
        placeIntent.putExtra("rating", place.getRating());
        placeIntent.putExtra("address", place.getAddress());
        placeIntent.putExtra("review", place.getReview());

        // TODO: 17 - Pass Parcel object
        placeIntent.putExtra("place", place);
        mContext.startActivity(placeIntent);
    }

}
