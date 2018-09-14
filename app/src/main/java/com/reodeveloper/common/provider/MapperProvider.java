package com.reodeveloper.common.provider;

import com.reodeveloper.ghibli_locations.data.Mapper;
import com.reodeveloper.ghibli_locations.data.TwoWayMapper;
import com.reodeveloper.ghibli_locations.data.database.mapper.DbLocationMapper;
import com.reodeveloper.ghibli_locations.data.database.model.DbLocation;
import com.reodeveloper.ghibli_locations.data.retrofit.mapper.RfLocationMapper;
import com.reodeveloper.ghibli_locations.data.retrofit.model.RfLocation;
import com.reodeveloper.ghibli_locations.domain.model.Location;

public class MapperProvider {
    public static Mapper<RfLocation,Location> provideRfLocationMapper() {
        return new RfLocationMapper();
    }

    public static TwoWayMapper<DbLocation, Location> provideDbLocationMapper(){
        return new DbLocationMapper();
    }
}
