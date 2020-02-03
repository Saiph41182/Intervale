package com.michailpiskunov.myapplication.viewmodel;

import android.os.Bundle;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.michailpiskunov.myapplication.model.ItemLocationListRealmModel;
import com.michailpiskunov.myapplication.view.MainActivity;
import com.michailpiskunov.myapplication.view.WeatherDetailsFragment;

public class ItemLocationListViewModel extends BaseObservable {

    private ItemLocationListRealmModel model;

    public ItemLocationListViewModel(ItemLocationListRealmModel model) {
        this.model = model;
    }

    @Bindable
    public String getCity(){
        return model.getCity();
    }

    @Bindable
    public String getDegree(){
        if(model != null){
            int intTemp = (int)Math.round(model.getDeg() - 273.15);
            String strTemp = intTemp > 0 ? "+" : "";
            return strTemp.concat(String.valueOf(intTemp));
        }
        return "";
    }

    public void startFragment(View view){
        WeatherDetailsFragment weatherDetailsFragment = new WeatherDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("city",getCity());
        weatherDetailsFragment.setArguments(bundle);
        ((MainActivity)view.getContext()).startFragment(weatherDetailsFragment);
    }
}
