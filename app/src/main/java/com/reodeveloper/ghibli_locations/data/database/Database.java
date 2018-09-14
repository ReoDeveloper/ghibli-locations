package com.reodeveloper.ghibli_locations.data.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class Database {
    private static final String DATABASE_NAME = "user-database";
    private static RoomDb instance;

    public static RoomDb getDbInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), RoomDb.class, DATABASE_NAME).build();
        }
        return instance;
    }

    public static void destroyInstance(){
        instance = null;
    }
}
