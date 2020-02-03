package com.michailpiskunov.myapplication.internet;

import com.michailpiskunov.myapplication.model.weekly.ForecastModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherWeeklyApi {

    @GET("/data/2.5/forecast")
    Observable<ForecastModel> getWeeklyForecast(
            @Query("q") String city,
            @Query("appid") String apiKey);

    @GET("/data/2.5/forecast")
    Observable<ForecastModel> getWeeklyForecast(
            @Query("lat") String lat,
            @Query("lon") String lon,
            @Query("appid") String apiKey);

}
