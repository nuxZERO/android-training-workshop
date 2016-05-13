package me.cafecode.android.workshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import java.util.Locale;

import me.cafecode.android.workshop.endpoints.GooglePlaceService;
import me.cafecode.android.workshop.models.DetailsResponse;
import me.cafecode.android.workshop.models.Location;
import me.cafecode.android.workshop.models.Photo;
import me.cafecode.android.workshop.models.Place;
import me.cafecode.android.workshop.models.Review;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PlaceDetailFragment extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PLACE_ID = "place_id";

    private String mPlaceId;

    private ImageView mPhotoImage;
    private TextView mNameText;
    private TextView mRatingText;
    private TextView mAddressText;
    private RatingBar mRatingBar;
    private ScrollView mContentScrollView;
    private ProgressBar mLoadingProgressBar;

    private ImageView mAuthor1Image;
    private TextView mAuthor1NameText;
    private TextView mAuthor1ReviewText;

    private ImageView mAuthor2Image;
    private TextView mAuthor2NameText;
    private TextView mAuthor2ReviewText;

    private ImageView mAuthor3Image;
    private TextView mAuthor3NameText;
    private TextView mAuthor3ReviewText;
    private GoogleMap mGoogleMap;

    public PlaceDetailFragment() {
        // Required empty public constructor
    }

    public static PlaceDetailFragment newInstance(String placeId) {
        PlaceDetailFragment fragment = new PlaceDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PLACE_ID, placeId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPlaceId = getArguments().getString(ARG_PLACE_ID);
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
        mRatingBar = (RatingBar) view.findViewById(R.id.place_detail_rating_bar);
        mContentScrollView = (ScrollView) view.findViewById(R.id.place_detail_scroll_view);
        mLoadingProgressBar = (ProgressBar) view.findViewById(R.id.place_detail_progress_bar);

        mAuthor1Image = (ImageView) view.findViewById(R.id.place_detail_author_1_image);
        mAuthor1NameText = (TextView) view.findViewById(R.id.place_detail_author_1_text);
        mAuthor1ReviewText = (TextView) view.findViewById(R.id.place_detail_review_1_text);

        mAuthor2Image = (ImageView) view.findViewById(R.id.place_detail_author_2_image);
        mAuthor2NameText = (TextView) view.findViewById(R.id.place_detail_author_2_text);
        mAuthor2ReviewText = (TextView) view.findViewById(R.id.place_detail_review_2_text);

        mAuthor3Image = (ImageView) view.findViewById(R.id.place_detail_author_3_image);
        mAuthor3NameText = (TextView) view.findViewById(R.id.place_detail_author_3_text);
        mAuthor3ReviewText = (TextView) view.findViewById(R.id.place_detail_review_3_text);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO: Google Map
        final SupportMapFragment mapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.place_detail_map);
        mapFragment.getMapAsync(this);

        requestDetails(mPlaceId);
    }

    private void requestDetails(String placeId) {
        mLoadingProgressBar.setVisibility(View.VISIBLE);
        mContentScrollView.setVisibility(View.GONE);
        // TODO: Crate request to request details endpoint
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GooglePlaceService service = retrofit.create(GooglePlaceService.class);
        Call<DetailsResponse> call = service.details(Constants.API_KEY, placeId);
        call.enqueue(new Callback<DetailsResponse>() {
            @Override
            public void onResponse(Call<DetailsResponse> call, Response<DetailsResponse> response) {
                final Place place = response.body().getPlace();
                updateViews(place);
            }

            @Override
            public void onFailure(Call<DetailsResponse> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateViews(Place place) {
        // TODO: 20 - Bind views with place object
        mLoadingProgressBar.setVisibility(View.GONE);
        mContentScrollView.setVisibility(View.VISIBLE);
        try {
            Photo photo = place.getPhotos().get(0);
            Picasso.with(getActivity())
                    .load(String.format(Constants.GOOGLE_PLACE_PHOTO_URL, photo.getPhotoReference(), Constants.API_KEY))
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(mPhotoImage);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            mPhotoImage.setImageResource(R.drawable.placeholder);
        }
        mNameText.setText(place.getName());
        mAddressText.setText(place.getAddress());
        mRatingText.setText(String.format(Locale.getDefault(), "%.1f", place.getRating()));
        mRatingBar.setRating((float) place.getRating());

        // Set review views

        // Author 1
        final Review review1 = place.getReviews().get(0);
        Picasso.with(getActivity())
                .load("https:" + review1.getProfilePhotoUrl())
                .placeholder(R.drawable.ic_account_circle_black_24dp)
                .into(mAuthor1Image);
        mAuthor1NameText.setText(review1.getAuthorName());
        mAuthor1ReviewText.setText(review1.getText());

        // Author 2
        final Review review2 = place.getReviews().get(1);
        Picasso.with(getActivity())
                .load("https:" + review2.getProfilePhotoUrl())
                .placeholder(R.drawable.ic_account_circle_black_24dp)
                .into(mAuthor2Image);
        mAuthor2NameText.setText(review2.getAuthorName());
        mAuthor2ReviewText.setText(review2.getText());

        // Author 3
        final Review review3 = place.getReviews().get(2);
        Picasso.with(getActivity())
                .load("https:" + review3.getProfilePhotoUrl())
                .placeholder(R.drawable.ic_account_circle_black_24dp)
                .into(mAuthor3Image);
        mAuthor3NameText.setText(review3.getAuthorName());
        mAuthor3ReviewText.setText(review3.getText());

        // Set view on Google Maps
        updateGoogleMapsView(place.getGeometry().getLocation());
    }

    private void updateGoogleMapsView(Location location) {
        // TODO: Google Map set center
        final LatLng centerLatLng = new LatLng(location.getLatitude(), location.getLongitude());
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerLatLng, 15.f));

        // TODO: Google Map option
        mGoogleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mGoogleMap.getUiSettings().setAllGesturesEnabled(false);

        // TODO: Google Map add marker
        mGoogleMap.addMarker(new MarkerOptions()
                .position(centerLatLng));
    }

    // TODO: Google Map Sync
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
    }

}
