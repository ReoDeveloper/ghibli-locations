package com.reodeveloper.ghibli_locations.domain.usecase;

import android.os.Handler;
import android.os.Looper;

import com.reodeveloper.common.repository.Repository;
import com.reodeveloper.common.usecase.UseCase;
import com.reodeveloper.ghibli_locations.domain.model.Location;

import java.util.List;

public class GetLocations extends UseCase<Location> {

    public GetLocations(Repository<Location> repository) {
        super(repository);
    }

    @Override
    public void execute(final Result<Location> callback) {
        final List<Location> items = repository.getAll();

        Handler mainHandler = new Handler(Looper.getMainLooper());
        mainHandler.post(new Runnable() {
            @Override public void run() {
                if (items != null) {
                    callback.success(items);
                } else {
                    callback.error("No results available");
                }
            }
        });
    }
}
