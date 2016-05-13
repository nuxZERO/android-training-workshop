package me.cafecode.android.workshop;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.Locale;

public class PlaceDetailFragment extends Fragment {


    // TODO: Rename and change types of parameters
    private static final String ARG_PHOTO = "photo";
    private static final String ARG_NAME = "name";
    private static final String ARG_RATING = "rating";
    private static final String ARG_ADDRESS = "address";
    private static final String ARG_REVIEW = "review";

    @DrawableRes
    private int mPhoto;
    private String mName;
    private double mRating;
    private String mAddress;
    private String mReview;

    private ImageView mPhotoImage;
    private TextView mNameText;
    private TextView mRatingText;
    private TextView mAddressText;
    private TextView mReviewText;
    private RatingBar mRatingBar;

    public PlaceDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Create instance
    public static PlaceDetailFragment newInstance(@DrawableRes int photo, String name, double rating, String address, String review) {
        PlaceDetailFragment fragment = new PlaceDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PHOTO, photo);
        args.putString(ARG_NAME, name);
        args.putDouble(ARG_RATING, rating);
        args.putString(ARG_ADDRESS, address);
        args.putString(ARG_REVIEW, review);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPhoto = getArguments().getInt(ARG_PHOTO);
            mName = getArguments().getString(ARG_NAME);
            mRating = getArguments().getDouble(ARG_RATING);
            mAddress = getArguments().getString(ARG_ADDRESS);
            mReview = getArguments().getString(ARG_REVIEW);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_detail, container, false);

        mPhotoImage = (ImageView) view.findViewById(R.id.place_detail_photo_image);
        mNameText = (TextView) view.findViewById(R.id.place_detail_name_text);
        mRatingText = (TextView) view.findViewById(R.id.place_detail_rating_text);
        mAddressText = (TextView) view.findViewById(R.id.place_detail_address_text);
        mReviewText = (TextView) view.findViewById(R.id.place_detail_review_text);
        mRatingBar = (RatingBar) view.findViewById(R.id.place_detail_rating_bar);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPhotoImage.setImageResource(mPhoto);
        mNameText.setText(mName);
        mAddressText.setText(mAddress);
        mRatingText.setText(String.format(Locale.getDefault(), "%.1f", mRating));
        mReviewText.setText(mReview);
        mRatingBar.setRating((float) mRating);
    }

}
