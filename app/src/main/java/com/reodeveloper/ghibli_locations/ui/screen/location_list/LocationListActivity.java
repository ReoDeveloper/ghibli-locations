package com.reodeveloper.ghibli_locations.ui.screen.location_list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.reodeveloper.ghibli_locations.R;
import com.reodeveloper.ghibli_locations.model.Location;

import java.util.List;

public class LocationListActivity extends AppCompatActivity implements LocationListContract.View {

    private RecyclerView recyclerView;
    private LocationListContract.Actions presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        presenter = new LocationListPresenter(this);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showLocations(List<Location> items) {
        LocationsAdapter adapter = new LocationsAdapter(items, new LocationsAdapter.LocationListItemClickListener() {
            @Override
            public void onItemClick(Location item) {
                presenter.onLocationTap(item);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void showError(String error) {

    }
}
