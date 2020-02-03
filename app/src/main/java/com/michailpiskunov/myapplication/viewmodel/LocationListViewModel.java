package com.michailpiskunov.myapplication.viewmodel;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableList;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.model.ItemLocationListRealmModel;
import com.michailpiskunov.myapplication.repository.LocationListRepo;
import com.michailpiskunov.myapplication.view.adapter.LocationListAdapter;

import javax.inject.Inject;

public class LocationListViewModel extends BaseObservable {

    @Inject Context context;
    LocationListRepo repo = new LocationListRepo();

    private ObservableList<ItemLocationListRealmModel> data;
    private String text;

    public LocationListViewModel() {
        data = repo.getCityList();
    }

    @Bindable
    public LocationListAdapter getLocationAdapter(){
        return new LocationListAdapter();
    }

    @Bindable
    public LinearLayoutManager getLocationLayoutManager(){
        return new LinearLayoutManager(context, RecyclerView.VERTICAL,false);
    }

    @Bindable
    public String getText(){
        return text;
    }


    public ObservableList<ItemLocationListRealmModel> getData(){
        return data;
    }

    public void setText(String text){
        if(this.text != null && text != null) {
            if (!this.text.equals(text)) {
                this.text = text;
                notifyPropertyChanged(BR.text);
            }
        }else{
            this.text = text;
        }
    }

    public void onClick(View view){
        repo.update(text);

    }

    public void updateAll() {
        repo.updateAll();
    }

}
