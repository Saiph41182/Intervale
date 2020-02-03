package com.michailpiskunov.myapplication.model.daily;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;

public class CurrentDayModel {

    @SerializedName("coord")
    @Expose
    private Coordinates coordinates;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("dt")
    @Expose
    private Long dt;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("cod")
    @Expose
    private Integer cod;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Long getDt() {
        Log.d("WeeklyForecastViewModel", "getDt: long "+ dt);
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrentDayModel)) return false;
        CurrentDayModel that = (CurrentDayModel) o;
        return Objects.equals(getCoordinates(), that.getCoordinates()) &&
                Objects.equals(getWeather(), that.getWeather()) &&
                Objects.equals(getMain(), that.getMain()) &&
                Objects.equals(getWind(), that.getWind()) &&
                Objects.equals(getDt(), that.getDt()) &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCod(), that.getCod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinates(), getWeather(), getMain(), getWind(), getDt(), getId(), getName(), getCod());
    }
}