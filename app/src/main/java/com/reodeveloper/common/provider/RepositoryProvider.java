package com.reodeveloper.common.provider;

import android.content.Context;

import com.reodeveloper.common.repository.Repository;
import com.reodeveloper.ghibli_locations.data.LocationRepository;
import com.reodeveloper.ghibli_locations.domain.model.Location;

public class RepositoryProvider {
    static Repository<Location> provideLocationRepository(Context context){
        LocationRepository repository = new LocationRepository(DatasourceProvider.provideLocationRfDatasource());
        repository.addDatasource(DatasourceProvider.provideLocationDbDatasource(context));
        return repository;
    }
}
