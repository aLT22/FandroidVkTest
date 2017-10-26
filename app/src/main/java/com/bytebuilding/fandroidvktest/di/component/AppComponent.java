package com.bytebuilding.fandroidvktest.di.component;

import com.bytebuilding.fandroidvktest.di.module.ApplicationModule;
import com.bytebuilding.fandroidvktest.di.module.ManagerModule;
import com.bytebuilding.fandroidvktest.di.module.RestModule;
import com.bytebuilding.fandroidvktest.ui.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Turkin A. on 26.10.17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface AppComponent {

    //Activity inject
    void inject(BaseActivity activity);

}
