package me.cafecode.android.workshop;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.cafecode.android.workshop.adapters.PlaceAdapter;
import me.cafecode.android.workshop.models.Place;
import me.cafecode.android.workshop.models.PlaceList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init list of mPlaces
        List<Place> places = PlaceList.getPlaceList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.place_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false);
        recyclerView.setLayoutManager(layoutManager);
        PlaceAdapter adapter = new PlaceAdapter(this, places);
        recyclerView.setAdapter(adapter);


        // TODO: Custom ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(R.layout.action_bar);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
        }
    }

}
