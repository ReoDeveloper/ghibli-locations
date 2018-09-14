package com.reodeveloper.ghibli_locations.data.database.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "location")
public class DbLocation {

    @PrimaryKey
    @NonNull
    private String id;

    private String name;
    private String climate;
    private String terrain;

    @NonNull
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }
}
