package com.example.dim.wineroom.controllers;

import android.util.Log;

import com.example.dim.wineroom.entities.Grape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * todo: unitTest
 */
public class ApplicationDataController implements Serializable {

    private final String ARG_APPDATA="DataCtrlr";

    List<Grape> dataList;
    Grape selGrape;
    Grape selClone;

    public ApplicationDataController(List<Grape> dataList) {
        this.dataList = new ArrayList<>(dataList);

        if (!dataList.isEmpty()) {
            selGrape = this.dataList.get(0);
            selGrapeToSelClone();
        }
    }

    private void selGrapeToSelClone() {
        try {
            selClone = selGrape.clone();
        } catch (CloneNotSupportedException e) {
            Log.i(ARG_APPDATA, "----- CloneNotSupportedException");
            e.printStackTrace();
        }
    }

    private void selCloneToSelGrape() {
        try {
            selGrape = selClone.clone();
        } catch (CloneNotSupportedException e) {
            Log.i(ARG_APPDATA, "----- CloneNotSupportedException");
            e.printStackTrace();
        }
    }

}
