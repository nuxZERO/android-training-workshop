package me.cafecode.android.workshop.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import me.cafecode.android.workshop.R;

/**
 * Created by Natthawut Hemathulin on 4/5/16 AD.
 * Email: natthawut1991@gmail.com
 */
// TODO: 10 - Make PlaceViewHolder is subclass of RecyclerView.ViewHolder
public class PlaceViewHolder extends RecyclerView.ViewHolder {

    // TODO: 11 - Create fields
    public ImageView photoImage;
    public TextView nameText;
    public TextView ratingText;
    public TextView addressText;

    public PlaceViewHolder(View itemView) {
        super(itemView);
        // TODO: 12 - Get view from `adapter_place` layout
        photoImage = (ImageView) itemView.findViewById(R.id.place_image);
        nameText = (TextView) itemView.findViewById(R.id.place_name_text);
        ratingText = (TextView) itemView.findViewById(R.id.place_rating_text);
        addressText = (TextView) itemView.findViewById(R.id.place_address_text);

    }

}
