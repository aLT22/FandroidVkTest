package com.bytebuilding.fandroidvktest.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;

/**
 * Created by Turkin A. on 23.10.17.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

    public static final String TAG = BaseFragment.class.getSimpleName();

    @LayoutRes
    public abstract int getMainContentLayoutRes();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getMainContentLayoutRes(), container, false);

        return rootView;
    }

    public String createToolbarTitle(Context context) {
        return context.getString(getToolbarTitleStringRes());
    }

    @StringRes
    public abstract int getToolbarTitleStringRes();
}
