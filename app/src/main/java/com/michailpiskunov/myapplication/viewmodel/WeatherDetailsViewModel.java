package com.michailpiskunov.myapplication.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.ObservableField;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.BR;
import com.michailpiskunov.myapplication.model.daily.CurrentDayModel;
import com.michailpiskunov.myapplication.repository.DailyForecastRepo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

@SuppressWarnings("ConstantConditions")
public class WeatherDetailsViewModel extends BaseObservable {

    DailyForecastRepo repo = new DailyForecastRepo();

    private ObservableField<CurrentDayModel> weather;
    private boolean visibility = true;
    private String mCity;

    public WeatherDetailsViewModel() {
        weather = repo.getDailyWeatherDataBy();
        weather.addOnPropertyChangedCallback(callback);
    }

    public void init(String city) {
        mCity = city;
        repo.update(mCity);
    }

    public void onResume(){
        repo.update(mCity);
    }

    @Bindable
    public String getCity(){
        return (weather == null || weather.get() == null) ? "" : weather.get().getName();
    }

    @Bindable
    public String getDate(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM",Locale.US);
        return dateFormat.format(calendar.getTime());
    }

    @Bindable
    public String getTemp(){
        if(weather != null && weather.get() != null){
            int intTemp = (int)Math.round(weather.get().getMain().getTemp() - 273.15);
            String strTemp = intTemp > 0 ? "+" : "-";
            return strTemp.concat(String.valueOf(intTemp));
        }
        return "";
    }

    @Bindable
    public String getDescription(){
        return (weather == null || weather.get() == null) ? "" : weather.get().getWeather().get(0).getDescription();
    }

    @Bindable
    public String getPressure(){
        return (weather == null || weather.get() == null) ? "" : weather.get().getMain().getPressure().toString();
    }

    @Bindable
    public String getHumidity(){
        return (weather == null || weather.get() == null) ? "" : weather.get().getMain().getHumidity().toString();
    }

    @Bindable
    public String getWindSpeed(){
        return (weather == null || weather.get() == null) ? "" : weather.get().getWind().getSpeed().toString();
    }

    @Bindable
    public boolean isVisible(){
        return visibility;
    }

    public void setVisibility(boolean visibility){
        this.visibility = visibility;
    }

    private OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
        @Override
        public void onPropertyChanged(Observable sender, int propertyId) {
            setVisibility(false);
            notifyPropertyChanged(propertyId);
        }
    };
}
