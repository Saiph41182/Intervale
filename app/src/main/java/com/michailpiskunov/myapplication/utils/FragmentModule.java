package com.michailpiskunov.myapplication.utils;

import androidx.fragment.app.Fragment;

import com.michailpiskunov.myapplication.viewmodel.LocationListViewModel;
import com.michailpiskunov.myapplication.viewmodel.WeatherDetailsViewModel;
import com.michailpiskunov.myapplication.viewmodel.WeeklyForecastViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @FragmentScope
    @Provides
    WeatherDetailsViewModel provideWeatherDetailsVM(){
        return new WeatherDetailsViewModel();
    }

    @FragmentScope
    @Provides
    WeeklyForecastViewModel provideWeeklyForecastVm(){
        return new WeeklyForecastViewModel();
    }

    @FragmentScope
    @Provides
    LocationListViewModel provideLocationListVm(){
        return new LocationListViewModel();
    }


}
