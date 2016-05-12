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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO: Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_place_list, container, false);

        // TODO: 05 - Get RecyclerView
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.place_list);

        // TODO: 06 - Set layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);

        // TODO: 14 - Set adapter
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), mPlaces);
        recyclerView.setAdapter(adapter);

        // TODO: On click listener
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Place place);
    }
}
