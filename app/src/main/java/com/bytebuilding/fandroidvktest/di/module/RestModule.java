package com.bytebuilding.fandroidvktest.di.module;

import com.bytebuilding.fandroidvktest.rest.RestClient;
import com.bytebuilding.fandroidvktest.rest.api.WallApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Turkin A. on 26.10.17.
 */

@Module
public class RestModule {

    private RestClient mRestClient;

    public RestModule() {
        mRestClient = new RestClient();
    }

    @Singleton
    @Provides
    RestClient provideRestClient() {
        return mRestClient;
    }

    @Singleton
    @Provides
    WallApi provideWallApi() {
        return mRestClient.createService(WallApi.class);
    }

}
