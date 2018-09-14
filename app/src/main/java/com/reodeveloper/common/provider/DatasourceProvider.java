package com.reodeveloper.common.provider;

import android.content.Context;

import com.reodeveloper.common.repository.DataSource;
import com.reodeveloper.ghibli_locations.data.database.LocationDbDatasource;
import com.reodeveloper.ghibli_locations.data.retrofit.LocationRfDatasource;
import com.reodeveloper.ghibli_locations.domain.model.Location;

public class DatasourceProvider {
    static DataSource<Location> provideLocationRfDatasource(){
        return new LocationRfDatasource(MapperProvider.provideRfLocationMapper());
    }

    public static DataSource<Location> provideLocationDbDatasource(Context context) {
        return new LocationDbDatasource(context, MapperProvider.provideDbLocationMapper());
    }
}
