package com.reodeveloper.ghibli_locations.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.reodeveloper.ghibli_locations.data.database.model.DbLocation;

@Database(entities = {DbLocation.class}, version = 1)
public abstract class RoomDb extends RoomDatabase {
    public abstract LocationDao locationModel();
}
