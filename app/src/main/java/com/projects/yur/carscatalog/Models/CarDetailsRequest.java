package com.projects.yur.carscatalog.Models;

import com.squareup.okhttp.RequestBody;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Yur on 27.09.2016.
 */

public interface CarDetailsRequest {
    @FormUrlEncoded
    @POST("CarDetails")
    Call<Car> getCarDetails(@Field("id") Integer id);
}
