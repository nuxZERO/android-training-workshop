package me.cafecode.android.workshop;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import me.cafecode.android.workshop.models.Place;

public class MainActivity extends AppCompatActivity
        implements PlaceListFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setCustomView(R.layout.action_bar);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayShowCustomEnabled(true);
        }

        // Is multi screen?
        if (findViewById(R.id.place_detail_content) != null) {
//            replacePlaceDetailFragment(mPlaces.get(0));
        } else if (findViewById(R.id.place_content) != null) {
            // Single page
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.place_content, new PlaceListFragment())
                    .commit();
        }

    }

    // Replace PlaceDetailFragment
    private void replacePlaceDetailFragment(Place place) {
        PlaceDetailFragment detailFragment = PlaceDetailFragment.newInstance(place.getId());
        if (findViewById(R.id.place_detail_content) != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.place_detail_content, detailFragment)
                    .commit();
        } else if (findViewById(R.id.place_content) != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.place_content, detailFragment)
                    .addToBackStack("detail")
                    .commit();
        }
    }

    // Implement fragment interaction
    @Override
    public void onFragmentInteraction(Place place) {
        Toast.makeText(MainActivity.this, place.getName(), Toast.LENGTH_SHORT).show();

        replacePlaceDetailFragment(place);

    }

}
