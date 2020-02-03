package com.michailpiskunov.myapplication.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.michailpiskunov.myapplication.model.weekly.WeatherItem;

public class ItemWeekViewModel extends BaseObservable {

    private WeatherItem model;

    public ItemWeekViewModel(WeatherItem model){
        this.model = model;
    }

    @Bindable
    public String getDate(){
        return model == null ? "" : model.getDtTxt().substring(5,10).replace("-",".");
    }

    @Bindable
    public String getMaxTemp(){
        if(model != null){
            int intTemp = (int)Math.round(model.getMain().getTempMax() - 273.15);
            String strTemp = intTemp > 0 ? "+" : "";
            return strTemp.concat(String.valueOf(intTemp));
        }
        return "";
    }

    @Bindable
    public String getMinTemp(){
        if(model != null){
            int intTemp = (int)Math.round(model.getMain().getTempMin() - 273.15);
            String strTemp = intTemp > 0 ? "+" : "";
            return strTemp.concat(String.valueOf(intTemp));
        }
        return "";
    }
}
