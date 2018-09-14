package com.reodeveloper.ghibli_locations.ui.screen.location_list;

import android.content.Context;

import com.reodeveloper.common.provider.UseCaseProvider;
import com.reodeveloper.common.usecase.Executor;
import com.reodeveloper.common.usecase.UseCase;
import com.reodeveloper.ghibli_locations.domain.model.Location;
import com.reodeveloper.ghibli_locations.domain.usecase.GetLocations;

import java.util.List;

public class LocationListPresenter implements LocationListContract.Actions {
    private final LocationListContract.View view;
    private Executor executor;
    private GetLocations getLocations;

    LocationListPresenter(LocationListContract.View view, Context context){
        this.view = view;
        executor = Executor.getInstance();
        getLocations = UseCaseProvider.provideGetLocationsUseCase(context);
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
        view.showError("Tapped on "+item.getName());
    }
}
