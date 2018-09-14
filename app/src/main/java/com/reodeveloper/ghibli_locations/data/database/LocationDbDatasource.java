package com.reodeveloper.ghibli_locations.data.database;

import android.content.Context;

import com.reodeveloper.common.repository.DataSource;
import com.reodeveloper.common.repository.Specification;
import com.reodeveloper.ghibli_locations.data.TwoWayMapper;
import com.reodeveloper.ghibli_locations.data.database.model.DbLocation;
import com.reodeveloper.ghibli_locations.domain.model.Location;

import java.util.List;


public class LocationDbDatasource implements DataSource<Location> {
    private RoomDb database;
    private final TwoWayMapper<DbLocation, Location> mapper;

    public LocationDbDatasource(Context context, TwoWayMapper<DbLocation, Location> mapper) {
        database = Database.getDbInstance(context);
        this.mapper = mapper;
    }

    @Override
    public void store(List<Location> items) {
        for (Location item: items) {
            database.locationModel().insertLocation(mapper.reverseMap(item));
        }
    }

    @Override
    public List<Location> getAll() {
        return mapper.map(database.locationModel().getAllDbLocation());
    }

    @Override
    public List<Location> queryList(Specification specification) {
        return null;
    }

    @Override
    public Location queryItem(Specification specification) {
        return null;
    }
}
