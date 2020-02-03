package com.michailpiskunov.myapplication.utils;

import com.michailpiskunov.myapplication.db.RealmDbHelper;
import com.michailpiskunov.myapplication.repository.DailyForecastRepo;
import com.michailpiskunov.myapplication.repository.LocationListRepo;
import com.michailpiskunov.myapplication.repository.WeeklyForecastRepo;
import com.michailpiskunov.myapplication.viewmodel.WeeklyForecastViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    FragmentComponent subComponent(FragmentModule fragmentModule);

    void inject(WeeklyForecastViewModel viewModel);

    void inject(RealmDbHelper dbHelper);

    void inject(DailyForecastRepo repository);

    void inject(WeeklyForecastRepo repository);

    void inject(LocationListRepo repository);

}
