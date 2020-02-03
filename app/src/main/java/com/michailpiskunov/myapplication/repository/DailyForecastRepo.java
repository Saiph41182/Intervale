package com.michailpiskunov.myapplication.repository;

import androidx.databinding.ObservableField;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.BuildConfig;
import com.michailpiskunov.myapplication.internet.OpenWeatherApi;
import com.michailpiskunov.myapplication.model.daily.CurrentDayModel;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DailyForecastRepo {

    @Inject OpenWeatherApi service;

    private ObservableField<CurrentDayModel> data = new ObservableField<>();


    public DailyForecastRepo() {
        App.getAppComponent().inject(this);
    }

    public void update(String city){
        Disposable subscribe = service.getDailyForecast(city, BuildConfig.OpenWeatherApiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> data.set(result));
    }

    public ObservableField<CurrentDayModel> getDailyWeatherDataBy(){
        return data;
    }
}
