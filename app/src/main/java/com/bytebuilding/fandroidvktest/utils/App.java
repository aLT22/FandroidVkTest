package com.bytebuilding.fandroidvktest.utils;

import android.app.Application;

import com.bytebuilding.fandroidvktest.di.component.AppComponent;
import com.bytebuilding.fandroidvktest.di.component.DaggerAppComponent;
import com.bytebuilding.fandroidvktest.di.module.ApplicationModule;
import com.vk.sdk.VKSdk;

/**
 * Created by Turkin A. on 23.10.17.
 */

public class App extends Application {

    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();
        VKSdk.initialize(this);
    }

    private void initComponent() {
        sAppComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static AppComponent getsAppComponent() {
        return sAppComponent;
    }
}
