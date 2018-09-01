package com.reodeveloper.ghibli_locations.data.retrofit.mapper;

import com.reodeveloper.ghibli_locations.data.Mapper;
import com.reodeveloper.ghibli_locations.data.retrofit.model.RfLocation;
import com.reodeveloper.ghibli_locations.model.Location;

public class RfLocationMapper extends Mapper<RfLocation, Location> {

    @Override
    public Location map(RfLocation item) {
        Location result = new Location();
        result.setId(item.getId().hashCode());
        result.setName(item.getName());
        result.setClimate(item.getClimate());
        result.setPopulation(item.getResidentsCount());
        return result;
    }
}
