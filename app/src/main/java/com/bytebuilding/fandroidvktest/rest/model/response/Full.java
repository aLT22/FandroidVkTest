package com.bytebuilding.fandroidvktest.rest.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Turkin A. on 26.10.17.
 */

//parametrisirovanni type otveta
//dannii class bydet otvechat' za parsing sekcii otveta "response"
public class Full<T> {

    @SerializedName("response")
    @Expose
    public T response;

}
