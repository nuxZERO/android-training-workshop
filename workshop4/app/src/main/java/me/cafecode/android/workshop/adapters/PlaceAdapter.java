package me.cafecode.android.workshop.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.cafecode.android.workshop.DetailActivity;
import me.cafecode.android.workshop.R;
import me.cafecode.android.workshop.models.Place;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private List<Place> mPlaces;
    private Context mContext;

    public PlaceAdapter(Context context, List<Place> places) {
        mContext = context;
        mPlaces = places;
    }

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
        return mPlaces.size();
    }

    private void startPlaceDetailActivity(Place place) {
        Intent placeIntent = new Intent(mContext, DetailActivity.class);
        placeIntent.putExtra("place", place);
        mContext.startActivity(placeIntent);
    }

}
