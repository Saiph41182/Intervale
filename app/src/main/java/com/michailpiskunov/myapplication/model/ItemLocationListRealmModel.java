package com.michailpiskunov.myapplication.model;

import java.util.Objects;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class ItemLocationListRealmModel extends RealmObject {

    @PrimaryKey
    private String city;

    private float deg;

    public ItemLocationListRealmModel() {
    }


    public ItemLocationListRealmModel( String city, float deq) {
        this.city = city;
        this.deg = deq;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public String getCity() {
        return city;
    }

    public float getDeg() {
        return deg;
    }

}
