package com.example.taskexample.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.taskexample.network.entities.Metadatum;

import java.util.List;

@Dao
public interface MetadatumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Metadatum metadatum);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrders(List<Metadatum> order);

    @Delete
    void delete(Metadatum metadatum);

    @Query("UPDATE metadatums SET isSeen=:isSeen WHERE id = :id")
    void update(boolean isSeen, int id);

    @Query("DELETE FROM metadatums")
    void deleteAll();

    @Query("SELECT * FROM metadatums")
    LiveData<List<Metadatum>> getAllItems();
}
