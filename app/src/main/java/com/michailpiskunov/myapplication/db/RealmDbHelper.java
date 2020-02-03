package com.michailpiskunov.myapplication.db;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.model.ItemLocationListRealmModel;

import java.util.List;

import javax.inject.Inject;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class RealmDbHelper {

    @Inject Realm realm;

    public RealmDbHelper() {
        App.getAppComponent().inject(this);
    }


    public void put(ItemLocationListRealmModel object) {
        realm.executeTransaction(realm -> realm.insertOrUpdate(object));
    }

    public void putAll(List<ItemLocationListRealmModel> objects) {
        realm.executeTransaction(realm -> realm.insertOrUpdate(objects));
    }

    public RealmResults<ItemLocationListRealmModel> getAll() {
        return realm.where(ItemLocationListRealmModel.class).findAll();
    }

    public ItemLocationListRealmModel get(String name) {
        return realm.where(ItemLocationListRealmModel.class).equalTo("name",name).findFirst();
    }

    public boolean isEmpty() {
        return realm.isEmpty();
    }


}
