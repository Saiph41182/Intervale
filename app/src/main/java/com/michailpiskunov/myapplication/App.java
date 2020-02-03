package com.michailpiskunov.myapplication;

import android.app.Application;

import androidx.fragment.app.Fragment;

import com.michailpiskunov.myapplication.utils.AppComponent;
import com.michailpiskunov.myapplication.utils.AppModule;
import com.michailpiskunov.myapplication.utils.DaggerAppComponent;
import com.michailpiskunov.myapplication.utils.FragmentComponent;
import com.michailpiskunov.myapplication.utils.FragmentModule;

import io.realm.Realm;

public class App extends Application {

    private static AppComponent appComponent;
    private static FragmentComponent fragmentComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    private static void initFragmentComponent(Fragment fragment){
        fragmentComponent = appComponent.subComponent(new FragmentModule(fragment));
    }

    private void initRealm(){
        Realm.init(this);
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

    public static FragmentComponent getFragmentComponent(Fragment fragment){
        if(fragmentComponent == null){
            initFragmentComponent(fragment);
        }
        return fragmentComponent;
    }

    public static void destroyFragmentComponent(){
        fragmentComponent = null;
    }

}
