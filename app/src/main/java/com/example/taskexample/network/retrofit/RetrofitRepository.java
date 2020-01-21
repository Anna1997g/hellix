package com.example.taskexample.network.retrofit;

import androidx.lifecycle.MutableLiveData;

import com.example.taskexample.network.entities.BaseResult;
import com.example.taskexample.network.entities.Metadatum;

import java.util.List;

public class RetrofitRepository implements RequestManager.OnSearchListener {
    private MutableLiveData<List<Metadatum>> allResults;


    public RetrofitRepository() {
        allResults = new MutableLiveData<>();
    }

    public void search() {
        RequestManager.search(this);
    }

    public MutableLiveData<List<Metadatum>> getAllResults() {
        return allResults;
    }

    @Override
    public void onSearchSuccess(BaseResult baseResult) {
        allResults.setValue(baseResult.getMetadata());

    }

    @Override
    public void onFailure(String failureMsg) {
        allResults.setValue(null);
    }


}
