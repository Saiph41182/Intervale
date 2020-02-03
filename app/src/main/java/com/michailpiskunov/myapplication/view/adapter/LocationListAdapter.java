package com.michailpiskunov.myapplication.view.adapter;

import androidx.annotation.LayoutRes;

import com.michailpiskunov.myapplication.R;
import com.michailpiskunov.myapplication.model.ItemLocationListRealmModel;
import com.michailpiskunov.myapplication.viewmodel.ItemLocationListViewModel;

public class LocationListAdapter extends BaseAdapter<ItemLocationListRealmModel> {

    @LayoutRes private int layoutRes = R.layout.item_location_list;

    public LocationListAdapter(){
    }

    @Override
    protected Object getObjectForPosition(int position) {
        return new ItemLocationListViewModel(data.get(position));
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        return layoutRes;
    }
}
