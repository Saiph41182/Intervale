package com.michailpiskunov.myapplication.utils;

import com.michailpiskunov.myapplication.view.LocationListFragment;
import com.michailpiskunov.myapplication.view.WeatherDetailsFragment;
import com.michailpiskunov.myapplication.viewmodel.LocationListViewModel;
import com.michailpiskunov.myapplication.viewmodel.WeatherDetailsViewModel;
import com.michailpiskunov.myapplication.viewmodel.WeeklyForecastViewModel;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = {FragmentModule.class})
public interface FragmentComponent {

    void inject(WeatherDetailsFragment fragment);
    void inject(LocationListFragment fragment);

    void inject(LocationListViewModel viewModel);
    void inject(WeatherDetailsViewModel viewModel);
    void inject(WeeklyForecastViewModel viewModel);
}
