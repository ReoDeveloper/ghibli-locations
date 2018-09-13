package com.reodeveloper.ghibli_locations.ui.screen.location_list;

import com.reodeveloper.ghibli_locations.domain.model.Location;

import java.util.List;

public interface LocationListContract {

    interface View {
        void showLocations (List<Location> items);
        void showLoading(boolean show);
        void showError(String error);
    }
    interface Actions {
        void start();
        void onLocationTap(Location item);
    }
}
