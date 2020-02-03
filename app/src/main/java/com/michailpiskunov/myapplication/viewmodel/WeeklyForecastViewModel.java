package com.michailpiskunov.myapplication.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.model.weekly.WeatherItem;
import com.michailpiskunov.myapplication.repository.WeeklyForecastRepo;
import com.michailpiskunov.myapplication.utils.AppComponent;
import com.michailpiskunov.myapplication.view.adapter.WeatherForecastAdapter;

import javax.inject.Inject;


public class WeeklyForecastViewModel extends BaseObservable {

    @Inject Context context;
    WeeklyForecastRepo repo = new WeeklyForecastRepo();

    private ObservableList<WeatherItem> forecast;
    private String mCity;

    public WeeklyForecastViewModel() {
        App.getAppComponent().inject(this);
        forecast = repo.getDailyWeatherDataBy();
    }

    public void init(String city){
        mCity = city;
        repo.update(mCity);
    }


    public void onResume(){
        repo.update(mCity);
    }

    @Bindable
    public WeatherForecastAdapter getAdapter(){
        return new WeatherForecastAdapter();
    }

    @Bindable
    public LinearLayoutManager getLayoutManager(){
        return new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false);
    }


    public ObservableList<WeatherItem> getData(){
        return forecast;
    }
}
