package com.michailpiskunov.myapplication.utils;

import android.app.Application;
import android.content.Context;

import com.michailpiskunov.myapplication.db.DbHandler;
import com.michailpiskunov.myapplication.db.RealmDbHelper;
import com.michailpiskunov.myapplication.internet.OpenWeatherApi;
import com.michailpiskunov.myapplication.internet.OpenWeatherApiProvider;
import com.michailpiskunov.myapplication.internet.OpenWeatherWeeklyApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    OpenWeatherApi provideService(){
        return OpenWeatherApiProvider.getInstance().getService();
    }

    @Singleton
    @Provides
    OpenWeatherWeeklyApi provideWeeklyService(){
        return OpenWeatherApiProvider.getInstance().getWeeklyService();
    }

    @Singleton
    @Provides
    Realm provideRealm(){

        return Realm.getInstance(new RealmConfiguration.Builder().name("cache.realm").build());
    }

    @Singleton
    @Provides
    Context provideContext(){
        return application.getApplicationContext();
    }

    @Singleton
    @Provides
    RealmDbHelper provideDbHelper(){
        return new RealmDbHelper();
    }

}
