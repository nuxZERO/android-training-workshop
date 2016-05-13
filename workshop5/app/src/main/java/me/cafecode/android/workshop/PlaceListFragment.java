package me.cafecode.android.workshop;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import me.cafecode.android.workshop.adapters.PlaceAdapter;
import me.cafecode.android.workshop.models.Place;
import me.cafecode.android.workshop.models.PlaceList;

public class PlaceListFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private List<Place> mPlaces = PlaceList.getPlaceList();

    public PlaceListFragment() {
        // Required empty public constructor
    }

    // TODO: Set user interface
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_place_list, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.place_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), mPlaces);
        recyclerView.setAdapter(adapter);
        adapter.setOnPlaceClickListener(new PlaceAdapter.OnPlaceClickListener() {
            @Override
            public void onPlaceClickListener(Place place) {
                if (mListener != null) {
                    mListener.onFragmentInteraction(place);
                }
            }
        });

        return view;
    }

    // TODO: Communicating with Activity
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

        void onFragmentInteraction(Place place);
    }
}
