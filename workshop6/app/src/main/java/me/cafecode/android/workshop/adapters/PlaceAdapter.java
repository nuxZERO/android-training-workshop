package me.cafecode.android.workshop.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import me.cafecode.android.workshop.Constants;
import me.cafecode.android.workshop.R;
import me.cafecode.android.workshop.models.Place;

/**
 * Created by Natthawut Hemathulin on 4/5/16 AD.
 * Email: natthawut1991@gmail.com
 */
// TODO: 07 - Make PlaceAdapter is subclass of RecyclerView.Adapter<PlaceViewHolder>
public class PlaceAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private List<Place> mPlaces;
    private Context mContext;
    private OnPlaceClickListener mListener;

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
        holder.nameText.setText(place.getName());
        holder.ratingText.setText(Double.toString(place.getRating()));
        holder.addressText.setText(place.getVicinity());

        try {
            Picasso.with(mContext)
                    .load(String.format(Constants.GOOGLE_PLACE_PHOTO_URL, place.getPhotos().get(0).getPhotoReference(), Constants.API_KEY))
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(holder.photoImage);
        } catch (NullPointerException e) {

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onPlaceClickListener(place);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        // TODO: 13 - Return number of rows in RecyclerView
        return mPlaces == null ? 0 : mPlaces.size();
    }

    public void setOnPlaceClickListener(OnPlaceClickListener listener) {
        mListener = listener;
    }

    public void setPlaces(List<Place> places) {
        mPlaces = places;
    }

    public interface OnPlaceClickListener {
        void onPlaceClickListener(Place place);
    }
}
