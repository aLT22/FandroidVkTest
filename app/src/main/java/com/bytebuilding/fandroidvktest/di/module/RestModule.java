package com.bytebuilding.fandroidvktest.di.module;

import com.bytebuilding.fandroidvktest.rest.RestClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Turkin A. on 26.10.17.
 */

@Module
public class RestModule {

    @Singleton
    @Provides
    RestClient provideRestClient() {
        return new RestClient();
    }

}
