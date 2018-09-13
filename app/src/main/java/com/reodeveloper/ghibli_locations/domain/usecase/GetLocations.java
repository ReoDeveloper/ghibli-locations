package com.reodeveloper.ghibli_locations.domain.usecase;

import com.reodeveloper.common.repository.Repository;
import com.reodeveloper.common.usecase.UseCase;
import com.reodeveloper.ghibli_locations.domain.model.Location;

public class GetLocations extends UseCase<Location> {

    public GetLocations(Repository<Location> repository) {
        super(repository);
    }

    @Override
    public void execute(Result<Location> callback) {

    }
}
