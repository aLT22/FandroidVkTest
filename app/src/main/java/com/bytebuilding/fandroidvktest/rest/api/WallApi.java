package com.bytebuilding.fandroidvktest.rest.api;

import com.bytebuilding.fandroidvktest.rest.model.response.BaseItemResponse;
import com.bytebuilding.fandroidvktest.rest.model.response.Full;
import com.bytebuilding.fandroidvktest.utils.constant.AppConstants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Turkin A. on 26.10.17.
 */

public interface WallApi {

    @GET(AppConstants.WALL_GET)
    Call<Full<BaseItemResponse>> get(@Query("owner_id") String ownerId,
                                     @Query("access_token") String accessToken,
                                     @Query("extended") Integer extended,
                                     @Query("v") String version);

}
