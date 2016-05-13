package me.cafecode.android.workshop.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.cafecode.android.workshop.R;

public class PlaceViewHolder extends RecyclerView.ViewHolder {

    public ImageView photoImage;
    public TextView nameText;
    public TextView ratingText;
    public TextView addressText;

    public PlaceViewHolder(View itemView) {
        super(itemView);
        photoImage = (ImageView) itemView.findViewById(R.id.place_image);
        nameText = (TextView) itemView.findViewById(R.id.place_name_text);
        ratingText = (TextView) itemView.findViewById(R.id.place_rating_text);
        addressText = (TextView) itemView.findViewById(R.id.place_address_text);

    }

}
