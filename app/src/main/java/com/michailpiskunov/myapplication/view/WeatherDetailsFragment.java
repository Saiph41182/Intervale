package com.michailpiskunov.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.R;
import com.michailpiskunov.myapplication.databinding.FragmentWeatherDetailsBinding;
import com.michailpiskunov.myapplication.viewmodel.WeatherDetailsViewModel;
import com.michailpiskunov.myapplication.viewmodel.WeeklyForecastViewModel;

import javax.inject.Inject;

;
public class WeatherDetailsFragment extends Fragment {

    @Inject
    WeatherDetailsViewModel weatherDetailsWm;
    @Inject
    WeeklyForecastViewModel weeklyForecastVm;


    public WeatherDetailsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        App.getFragmentComponent(this).inject(this);

        FragmentWeatherDetailsBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_weather_details,
                container,
                false);

        binding.setDetailsVM(weatherDetailsWm);
        binding.setDataProviderVM(weeklyForecastVm);

        String city;
        if(getArguments() != null){
            city = getArguments().getString("city");
        }else {
            city = "Mogilev";
        }

        weatherDetailsWm.init(city);
        weeklyForecastVm.init(city);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        App.destroyFragmentComponent();
    }

    @Override
    public void onResume() {
        super.onResume();
        weeklyForecastVm.onResume();
        weatherDetailsWm.onResume();
    }
}
