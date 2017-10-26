package com.bytebuilding.fandroidvktest.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bytebuilding.fandroidvktest.R;

public class NewsFeedFragment extends BaseFragment {

    public static final String TAG = NewsFeedFragment.class.getSimpleName();

    public static NewsFeedFragment newInstance() {
        NewsFeedFragment fragment = new NewsFeedFragment();

        return fragment;
    }

    public static NewsFeedFragment newInstance(Bundle bundle) {
        NewsFeedFragment fragment = new NewsFeedFragment();

        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getMainContentLayoutRes() {
        return R.layout.fragment_news_feed;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_feed, container, false);

        return rootView;
    }

    @Override
    public int getToolbarTitleStringRes() {
        return R.string.title_news;
    }

}
