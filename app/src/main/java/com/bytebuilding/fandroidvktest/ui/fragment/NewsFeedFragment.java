package com.bytebuilding.fandroidvktest.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bytebuilding.fandroidvktest.CurrentUser;
import com.bytebuilding.fandroidvktest.R;
import com.bytebuilding.fandroidvktest.rest.api.WallApi;
import com.bytebuilding.fandroidvktest.rest.model.response.BaseItemResponse;
import com.bytebuilding.fandroidvktest.rest.model.response.Full;
import com.bytebuilding.fandroidvktest.utils.App;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeedFragment extends BaseFragment {

    public static final String TAG = NewsFeedFragment.class.getSimpleName();

    @Inject
    WallApi mWallApi;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get("-86529522",
                CurrentUser.getAccessToken(),
                1,
                "5.68 ").enqueue(new Callback<Full<BaseItemResponse>>() {
            @Override
            public void onResponse(Call<Full<BaseItemResponse>> call, Response<Full<BaseItemResponse>> response) {
                Toast.makeText(getActivity(), "Count: " + response.body().response.getCount(), Toast.LENGTH_LONG)
                        .show();
            }

            @Override
            public void onFailure(Call<Full<BaseItemResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        App.getsAppComponent().inject(this);
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
