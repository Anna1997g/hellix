package com.example.taskexample.network.retrofit;

import com.example.taskexample.network.entities.BaseResult;
import com.example.taskexample.utils.LogUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestManager {
    public static void search(final OnSearchListener onSearchListener) {
        Call<BaseResult> call = RetrofitClient.getInstance().getRequestApiService().search();
        call.enqueue(new Callback<BaseResult>() {
            @Override
            public void onResponse(Call<BaseResult> call, Response<BaseResult> response) {
                LogUtils.d(this.getClass().getSimpleName() + "message: " + response.message());
                if (response.body() != null) {
                    onSearchListener.onSearchSuccess(response.body());
                    LogUtils.d("code: " + response.body().toString());
                }
//                else {
//                    onSearchListener.onError(response.errorBody ().toString ());
//                    LogUtils.d("code: body is null");
//                }
            }

            @Override
            public void onFailure(Call<BaseResult> call, Throwable t) {
                onSearchListener.onFailure(t.toString());
                LogUtils.d("onFailure: call" + call.toString());
                LogUtils.d("onFailure: throwable" + t.toString());
            }
        });


    }

    public interface OnSearchListener {
        void onSearchSuccess(BaseResult baseResult);

        void onFailure(String failureMsg);
    }

}
