package com.reodeveloper.ghibli_locations.data.retrofit.model;

import java.util.List;

public class RfLocation {

    private final static String NO_RESIDENTS = "TODO";

    private String id;
    private String name;
    private String climate;
    private String terrain;
    private String surface_water;
    private List<String> residents;
    private List<String> films;
    private List<String> url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }

    public void setSurface_water(String surface_water) {
        this.surface_water = surface_water;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public int getResidentsCount(){
        int size = residents.size();
        // If there is more than 1 element we are sure the parameter is ok
        if(size > 1) {
            return size;
        }
        // Check if the residents parameter is correctly filled
        if(size == 1 && !residents.get(0).equals(NO_RESIDENTS)){
            return size;
        }

        // This will be 0
        return size;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
