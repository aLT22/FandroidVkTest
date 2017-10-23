package com.bytebuilding.fandroidvktest.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bytebuilding.fandroidvktest.CurrentUser;
import com.bytebuilding.fandroidvktest.mvp.view.MainView;

/**
 * Created by Turkin A. on 23.10.17.
 */

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth() {
        if (!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedIn();
        }
    }

}
