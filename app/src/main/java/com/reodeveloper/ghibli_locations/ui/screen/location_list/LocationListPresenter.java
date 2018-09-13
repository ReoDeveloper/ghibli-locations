package com.reodeveloper.ghibli_locations.ui.screen.location_list;

import com.reodeveloper.common.repository.Repository;
import com.reodeveloper.common.usecase.Executor;
import com.reodeveloper.common.usecase.UseCase;
import com.reodeveloper.ghibli_locations.data.retrofit.LocationRfDatasource;
import com.reodeveloper.ghibli_locations.data.retrofit.mapper.RfLocationMapper;
import com.reodeveloper.ghibli_locations.domain.model.Location;
import com.reodeveloper.ghibli_locations.domain.usecase.GetLocations;

import java.util.List;

public class LocationListPresenter implements LocationListContract.Actions {
    private final LocationListContract.View view;
    private Executor executor;
    private GetLocations getLocations;

    LocationListPresenter(LocationListContract.View view){
        this.view = view;
        executor = Executor.getInstance();
        getLocations = new GetLocations(new Repository<>(new LocationRfDatasource(new RfLocationMapper())));
    }

    @Override
    public void start() {
        executor.execute(getLocations, new UseCase.Result<Location>() {
            @Override
            public void success(List<Location> result) {
                view.showLocations(result);
            }

            @Override
            public void error(String message) {
                view.showError(message);
            }
        });
    }

    @Override
    public void onLocationTap(Location item) {
        //TODO: Go to a detail activity
    }
}
