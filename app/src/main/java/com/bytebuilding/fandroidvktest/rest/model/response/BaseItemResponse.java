package com.bytebuilding.fandroidvktest.rest.model.response;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Turkin A. on 26.10.17.
 */

public class BaseItemResponse<T> {

    public Integer count;

    public List<T> items = new LinkedList<>();

    public List<T> profiles = new LinkedList<>();

    public List<T> groups = new LinkedList<>();

    public Integer getCount() {
        return count;
    }

    public List<T> getItems() {
        return items;
    }

    public List<T> getProfiles() {
        return profiles;
    }

    public List<T> getGroups() {
        return groups;
    }
}
