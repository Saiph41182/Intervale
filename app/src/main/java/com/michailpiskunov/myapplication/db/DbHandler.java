package com.michailpiskunov.myapplication.db;

import java.util.List;

import io.realm.RealmObject;
import io.realm.RealmResults;

public interface DbHandler{

    void put(RealmObject object);

    void putAll(List<RealmObject> objects);

    RealmResults getAll();

    RealmObject get(String name);

    boolean isEmpty();

}
