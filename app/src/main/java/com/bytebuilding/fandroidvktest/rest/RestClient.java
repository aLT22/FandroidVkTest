package com.bytebuilding.fandroidvktest.rest;

import com.bytebuilding.fandroidvktest.utils.constant.ApiConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Turkin A. on 26.10.17.
 */

public class RestClient {

    private Retrofit mRetrofit;

    public RestClient() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiConstants.VK_BASE_URL)
                .build();
    }

    //Create variables/methods for initializing rest-api services
    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

}
