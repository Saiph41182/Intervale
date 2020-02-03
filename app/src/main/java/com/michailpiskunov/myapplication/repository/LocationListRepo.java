package com.michailpiskunov.myapplication.repository;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.BuildConfig;
import com.michailpiskunov.myapplication.db.RealmDbHelper;
import com.michailpiskunov.myapplication.db.RealmModelMapper;
import com.michailpiskunov.myapplication.internet.OpenWeatherApi;
import com.michailpiskunov.myapplication.model.ItemLocationListRealmModel;
import com.michailpiskunov.myapplication.model.daily.CurrentDayModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmResults;

public class LocationListRepo {

    private final String[] defaultFields = {"Homyel","Minsk"};
    private ObservableList<ItemLocationListRealmModel> data = new ObservableArrayList<>();

    @Inject
    RealmDbHelper dbHelper;

    @Inject
    OpenWeatherApi service;

    public LocationListRepo() {
        App.getAppComponent().inject(this);
        Log.d("LocationList", "LocationListRepo: before init()");
        init();
    }

    public ObservableList<ItemLocationListRealmModel> getCityList(){
        preLoadedDataChecker();
        return data;
    }

    public void update(String city){
        Disposable subscribe = service.getDailyForecast(city, BuildConfig.OpenWeatherApiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(model -> {
                    dbHelper.put(RealmModelMapper.map(model));
                    Log.d("LocationListRepo", "update: in realm " + dbHelper.getAll().size());
                })
                .subscribe(model -> {
                    preLoadedDataChecker();
                });

    }

    private void preLoadedDataChecker() {
        if(data.isEmpty()) {
            data.addAll(dbHelper.getAll());
        }else{
            data.clear();
            data.addAll(dbHelper.getAll());
        }
    }

    private void init(){
        if(dbHelper.isEmpty()){
            Log.d("LocationList", "init: in is empty ");
            for (String city : defaultFields) {
                update(city);
            }
        }
    }

    public void updateAll() {
        for (ItemLocationListRealmModel model: dbHelper.getAll()) {
            update(model.getCity());
        }
    }
}
