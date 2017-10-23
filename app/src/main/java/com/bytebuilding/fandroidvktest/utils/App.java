package com.bytebuilding.fandroidvktest.utils;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Turkin A. on 23.10.17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VKSdk.initialize(this);
    }
}
