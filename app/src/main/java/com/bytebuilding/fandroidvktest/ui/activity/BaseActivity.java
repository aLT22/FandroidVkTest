package com.bytebuilding.fandroidvktest.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.bytebuilding.fandroidvktest.R;
import com.bytebuilding.fandroidvktest.common.manager.MyFragmentManager;
import com.bytebuilding.fandroidvktest.ui.fragment.BaseFragment;
import com.bytebuilding.fandroidvktest.utils.App;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Turkin A. on 23.10.17.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.main_wrapper)
    FrameLayout mWrapper;

    Unbinder unbinder = null;

    @Inject
    MyFragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        App.getsAppComponent().inject(this);

        unbinder = ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        getLayoutInflater().inflate(getMainContentLayoutRes(), mWrapper);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unbinder.unbind();
    }

    @LayoutRes
    protected abstract int getMainContentLayoutRes();

    //This method will be change toolbar header text and fab visibility
    public void fragmentOnScreen(BaseFragment fragment) {
        setToolbarTitle(fragment.createToolbarTitle(this));
    }

    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setFragment(BaseFragment fragment) {
        mFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment) {
        mFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment() {
        return mFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment) {
        return mFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}
