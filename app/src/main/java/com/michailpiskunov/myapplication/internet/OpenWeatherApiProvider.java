package com.michailpiskunov.myapplication.internet;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class OpenWeatherApiProvider {

    private static final String BASE_URL = "https://api.openweathermap.org";

    private static OpenWeatherApiProvider mInstance;

    private Retrofit retrofit;

    private OpenWeatherApiProvider(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static OpenWeatherApiProvider getInstance(){
        if(mInstance == null) {
            mInstance = new OpenWeatherApiProvider();
        }
        return mInstance;
    }

    public OpenWeatherApi getService(){
        return retrofit.create(OpenWeatherApi.class);
    }

    public OpenWeatherWeeklyApi getWeeklyService(){
        return retrofit.create(OpenWeatherWeeklyApi.class);
    }
}
