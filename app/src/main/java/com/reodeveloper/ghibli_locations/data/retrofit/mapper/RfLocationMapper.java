package com.reodeveloper.ghibli_locations.data.retrofit.mapper;

import com.reodeveloper.ghibli_locations.data.Mapper;
import com.reodeveloper.ghibli_locations.data.retrofit.model.RfLocation;
import com.reodeveloper.ghibli_locations.domain.model.Location;

public class RfLocationMapper extends Mapper<RfLocation, Location> {

    @Override
    public Location map(RfLocation item) {
        Location result = new Location();

        String id = item.getId();
        if(id != null){
            result.setId(id);
        }else{
            result.setId("Unknown");
        }

        String name = item.getName();
        if(name != null){
            result.setName(name);
        }else{
            result.setName("");
        }

        String climate = item.getClimate();
        if(climate != null){
            result.setClimate(climate);
        }else{
            result.setClimate("");
        }

        String terrain = item.getTerrain();
        if(terrain != null){
            result.setGeography(terrain);
        }else{
            result.setGeography("Unknown");
        }

        result.setPopulation(item.getResidentsCount());
        return result;
    }
}
