package com.reodeveloper.ghibli_locations.ui.screen.location_list;

import com.reodeveloper.ghibli_locations.model.Location;

public class LocationListPresenter implements LocationListContract.Actions {
    private final LocationListContract.View view;

    public LocationListPresenter(LocationListContract.View view){
        this.view = view;
    }

    @Override
    public void start() {

    }

    @Override
    public void onLocationTap(Location item) {
        
    }
}
