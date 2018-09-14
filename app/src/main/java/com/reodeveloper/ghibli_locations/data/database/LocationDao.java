package com.reodeveloper.ghibli_locations.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.reodeveloper.ghibli_locations.data.database.model.DbLocation;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface LocationDao {

    @Query("SELECT * FROM location")
    List<DbLocation> getAllDbLocation();

    @Insert(onConflict = IGNORE)
    void insertLocation(DbLocation item);

    @Update(onConflict = REPLACE)
    void updateLocation(DbLocation item);
}
