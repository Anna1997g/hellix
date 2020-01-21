package com.example.taskexample.network.retrofit;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.taskexample.network.entities.Metadatum;
import com.example.taskexample.room.MetadatumDBRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private RetrofitRepository retrofitRepository;
    private MutableLiveData<List<Metadatum>> metadatums;

    private MetadatumDBRepository metadatumDBRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        retrofitRepository = new RetrofitRepository();
        metadatums = retrofitRepository.getAllResults();
        metadatumDBRepository = new MetadatumDBRepository(application);
    }

    public void search() {
        retrofitRepository.search();
    }

    public MutableLiveData<List<Metadatum>> getMetadatums() {
        return metadatums;
    }

    public void insert(Metadatum metadatum) {
        metadatumDBRepository.insert(metadatum);
    }

    public void update(Metadatum metadatum) {
        metadatumDBRepository.update(metadatum);
    }

    public void insertOrders(List<Metadatum> metadatumList){
        metadatumDBRepository.insertOrders(metadatumList);
    }

    public void delete(Metadatum metadatum) {
        metadatumDBRepository.delete(metadatum);
    }

    public void deleteAll() {
        metadatumDBRepository.deleteAll();
    }

    public LiveData<List<Metadatum>> getAllResultsFromDB() {
        return metadatumDBRepository.getAllResults();
    }


}
