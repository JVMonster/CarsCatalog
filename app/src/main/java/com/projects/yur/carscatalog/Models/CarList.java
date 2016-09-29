package com.projects.yur.carscatalog.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yur on 28.09.2016.
 */

public class CarList {

    Car data;
    public CarList(Car data) {

        this.data = data;
    }

    public Car getData() {
        return data;
    }

    public void setData(Car data) {
        this.data = data;
    }

}
