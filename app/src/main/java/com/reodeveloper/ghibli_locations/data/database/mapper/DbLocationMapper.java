package com.reodeveloper.ghibli_locations.data.database.mapper;

import com.reodeveloper.ghibli_locations.data.TwoWayMapper;
import com.reodeveloper.ghibli_locations.data.database.model.DbLocation;
import com.reodeveloper.ghibli_locations.domain.model.Location;

public class DbLocationMapper extends TwoWayMapper<DbLocation, Location> {

    @Override
    public Location map(DbLocation item) {
        Location result = new Location();

        String id = item.getId();
        if(!id.isEmpty()){
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

        return result;
    }

    @Override
    public DbLocation reverseMap(Location item) {
        DbLocation result = new DbLocation();

        String id = item.getId();
        if(!id.isEmpty()){
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

        String terrain = item.getGeography();
        if(terrain != null){
            result.setTerrain(terrain);
        }else{
            result.setTerrain("Unknown");
        }

        return result;
    }
}
