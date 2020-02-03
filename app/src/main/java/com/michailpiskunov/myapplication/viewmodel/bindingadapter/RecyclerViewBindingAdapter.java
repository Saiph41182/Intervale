package com.michailpiskunov.myapplication.viewmodel.bindingadapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.michailpiskunov.myapplication.view.adapter.BaseAdapter;

import java.util.List;

public class RecyclerViewBindingAdapter {

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = {"app:layoutManager","app:adapter","app:data"})
    public static void initRecyclerView(@NonNull RecyclerView recyclerView,
                                        @NonNull RecyclerView.LayoutManager layoutManager,
                                        @NonNull BaseAdapter adapter,
                                        @NonNull List<?> data){

        adapter.updateData(data,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
