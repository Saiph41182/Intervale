package com.michailpiskunov.myapplication.repository;

import android.annotation.SuppressLint;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.BuildConfig;
import com.michailpiskunov.myapplication.internet.OpenWeatherWeeklyApi;
import com.michailpiskunov.myapplication.model.weekly.ForecastModel;
import com.michailpiskunov.myapplication.model.weekly.WeatherItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class WeeklyForecastRepo {

    @Inject
    OpenWeatherWeeklyApi service;

    private ObservableList<WeatherItem> data = new ObservableArrayList<>();

    public WeeklyForecastRepo() {
        App.getAppComponent().inject(this);
    }

    public void update(String city) {
        update(service.getWeeklyForecast(city, BuildConfig.OpenWeatherApiKey));
    }
    public void update(String lat,String lon){
        update(service.getWeeklyForecast(lat,lon, BuildConfig.OpenWeatherApiKey));

    }

    @SuppressLint("CheckResult")
    private void update(Observable<ForecastModel> service){
        service.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(ForecastModel::getList)
                .map(this::weatherItemsValidator)
                .subscribe(model -> {
                    if (data.isEmpty()) {
                        data.addAll(model);
                    }else {
                        data.clear();
                        data.addAll(model);
                    }
                });
    }
    /**
     * Это велосипед. Т.к. OpenWeather не предоставляет бесплатное API подневного прогноза погоды.
     * Единственное, что более менее близко подходит это 5-ти дневный прогноз с трехчасовой детализацией.
     * Поэтому я взял по первому элементу из трехчасового прогноза погоды за каждый день, начиная со следующего.
     * Можно было бы почситать среднее значение для всех величин и записать это в новую модель, но это та работа,
     * которая не имеет смысла.*/

    private List<WeatherItem> weatherItemsValidator(List<WeatherItem> list) {
        List<WeatherItem> finalList = new ArrayList<>();
        for (int i = 7; i < list.size(); i = i + 8) {
            finalList.add(list.get(i));
        }
        return finalList;
    }

    public ObservableList<WeatherItem> getDailyWeatherDataBy() {
        return data;
    }
}
