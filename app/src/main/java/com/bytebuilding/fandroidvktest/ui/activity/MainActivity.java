package com.bytebuilding.fandroidvktest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bytebuilding.fandroidvktest.CurrentUser;
import com.bytebuilding.fandroidvktest.R;
import com.bytebuilding.fandroidvktest.mvp.presenter.MainPresenter;
import com.bytebuilding.fandroidvktest.mvp.view.MainView;
import com.bytebuilding.fandroidvktest.ui.fragment.NewsFeedFragment;
import com.bytebuilding.fandroidvktest.utils.App;
import com.bytebuilding.fandroidvktest.utils.constant.AppConstants;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

public class MainActivity extends BaseActivity implements MainView {

    public static final String TAG = MainActivity.class.getSimpleName();

    @InjectPresenter
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getsAppComponent().inject(this);

        mMainPresenter.checkAuth();
    }

    @Override
    protected int getMainContentLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                mMainPresenter.checkAuth();
            }

            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, AppConstants.DEFAULT_LOGIN_SCOPES);
    }

    @Override
    public void signedIn() {
        Toast.makeText(this, "Current user id: " + CurrentUser.getId(), Toast.LENGTH_SHORT).show();
        setFragment(NewsFeedFragment.newInstance());
        Log.e(TAG, "signedIn: " + CurrentUser.getId());
    }
}
