package com.reodeveloper.ghibli_locations.data.retrofit.mapper;

import com.reodeveloper.ghibli_locations.data.Mapper;
import com.reodeveloper.ghibli_locations.data.retrofit.model.RfLocation;
import com.reodeveloper.ghibli_locations.model.Location;

public class RfLocationMapper extends Mapper<RfLocation, Location> {

    @Override
    public Location map(RfLocation item) {
        Location result = new Location();

        String id = item.getId();
        if(id != null){
            result.setId(id.hashCode());
        }else{
            result.setId(0);
        }

        String name = item.getName();
        if(name != null){
            result.setName(name);
        }else{
            result.setName("");
        }

        result.setClimate(item.getClimate());
        result.setPopulation(item.getResidentsCount());
        return result;
    }
}
