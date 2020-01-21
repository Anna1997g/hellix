package com.example.taskexample.network.retrofit;

import com.example.taskexample.network.entities.BaseResult;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestApiService {
    @GET("temp/json.php")
    Call<BaseResult> search();
}
