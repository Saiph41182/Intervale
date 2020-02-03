package com.michailpiskunov.myapplication.db;

import com.michailpiskunov.myapplication.model.ItemLocationListRealmModel;
import com.michailpiskunov.myapplication.model.daily.CurrentDayModel;

public class RealmModelMapper {

    public static ItemLocationListRealmModel map(CurrentDayModel model){
        return new ItemLocationListRealmModel(model.getName(),model.getMain().getTemp());
    }
}
