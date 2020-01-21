package com.example.taskexample.room;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.taskexample.network.entities.Metadatum;

@Database(entities = Metadatum.class, version = 5, exportSchema = false)
public abstract class MetadatumDatabase extends RoomDatabase {

    private static final String DB_NAME = "metadatums";

    abstract MetadatumDao metadatumDao();

    private static MetadatumDatabase instance;

    public static synchronized MetadatumDatabase getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(application, MetadatumDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
