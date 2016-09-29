package com.projects.yur.carscatalog.Models;

import java.util.List;

import retrofit.Call;

import retrofit.http.POST;

/**
 * Created by Yur on 26.09.2016.
 */

public interface CarsListRequest {
    @POST("CarsList")
    Call<CarList> getCarsList();

}
