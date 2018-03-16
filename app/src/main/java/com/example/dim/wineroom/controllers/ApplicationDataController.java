package com.example.dim.wineroom.controllers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cdsm on 3/16/18.
 */

public abstract class ApplicationDataController<T> {

    List<T> dataList;
    T selection;

    public ApplicationDataController(List<T> dataList) {
        this.dataList = dataList;

        if (!dataList.isEmpty()) {
            selection = dataList.get(0);
        }
    }

}
