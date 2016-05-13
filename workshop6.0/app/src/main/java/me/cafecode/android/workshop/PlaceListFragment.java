package me.cafecode.android.workshop;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import me.cafecode.android.workshop.adapters.PlaceAdapter;
import me.cafecode.android.workshop.endpoints.GooglePlaceService;
import me.cafecode.android.workshop.models.NearbySearchResponse;
import me.cafecode.android.workshop.models.Place;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PlaceListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private List<Place> mPlaces;
    private PlaceAdapter mPlaceAdapter;

    public PlaceListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.place_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        mPlaceAdapter = new PlaceAdapter(getActivity(), mPlaces);

        recyclerView.setAdapter(mPlaceAdapter);
        mPlaceAdapter.setOnPlaceClickListener(new PlaceAdapter.OnPlaceClickListener() {
            @Override
            public void onPlaceClickListener(Place place) {
                if (mListener != null) {
                    mListener.onFragmentInteraction(place);
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestNearbySearch();
    }

    // TODO: Crate request to request nearbysearch endpoint
    private void requestNearbySearch() {
        // Logging interceptor
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/place/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        GooglePlaceService service = retrofit.create(GooglePlaceService.class);
        Call<NearbySearchResponse> call = service.nearbySearch(Constants.API_KEY, "restaurant", "40.7058254,-74.1180862", "5000", "prominence");
        call.enqueue(new Callback<NearbySearchResponse>() {
            @Override
            public void onResponse(Call<NearbySearchResponse> call, Response<NearbySearchResponse> response) {
                // TODO: Set places adapter
                List<Place> places = response.body().getPlaces();
                mPlaceAdapter.setPlaces(places);
                mPlaceAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<NearbySearchResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Place place);
    }
}
