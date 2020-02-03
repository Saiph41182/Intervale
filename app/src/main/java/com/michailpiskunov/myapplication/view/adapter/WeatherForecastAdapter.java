package com.michailpiskunov.myapplication.view.adapter;

import androidx.annotation.LayoutRes;

import com.michailpiskunov.myapplication.R;
import com.michailpiskunov.myapplication.model.weekly.ForecastModel;
import com.michailpiskunov.myapplication.model.weekly.WeatherItem;
import com.michailpiskunov.myapplication.viewmodel.ItemWeekViewModel;

public class WeatherForecastAdapter extends BaseAdapter<WeatherItem> {

    @LayoutRes
    private final int layoutRes = R.layout.item_three_days_weather_forecast;

    public WeatherForecastAdapter() {
    }

    @Override
    protected Object getObjectForPosition(int position) {
        return new ItemWeekViewModel(data.get(position));
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutRes;
    }
}
