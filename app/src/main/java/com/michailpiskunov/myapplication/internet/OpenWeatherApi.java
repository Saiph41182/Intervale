package com.michailpiskunov.myapplication.internet;

import com.michailpiskunov.myapplication.model.daily.CurrentDayModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherApi {

    @GET("/data/2.5/weather")
    Observable<CurrentDayModel> getDailyForecast(
            @Query("q") String city,
            @Query("appid") String apiKey);

    @GET("/data/2.5/weather")
    Observable<CurrentDayModel> getDailyForecast(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("appid") String ApiKei);


}
