package com.michailpiskunov.myapplication.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.michailpiskunov.myapplication.BR;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {

    protected List<T> data;


    public BaseAdapter() {
        data = new ArrayList<>();
    }


    @NonNull
    @Override
    public BaseAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, viewType, parent, false);
        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.BaseViewHolder holder, int position) {
        Object obj = getObjectForPosition(position);
        holder.bind(obj);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void updateData(@Nullable List<T> data, boolean isReplaced){
        if(data == null || data.isEmpty()){
            this.data.clear();
        }else {
            if(isReplaced){
                this.data.clear();
                this.data.addAll(data);
            } else{
                this.data.addAll(data);
            }
        }
        notifyDataSetChanged();
    }

    protected abstract Object getObjectForPosition(int position);
    protected abstract int getLayoutIdForPosition(int position);


    class BaseViewHolder extends RecyclerView.ViewHolder{

        ViewDataBinding binding;

        BaseViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Object obj) {
            if(obj != null){
                binding.setVariable(BR.viewModel,obj);
                binding.executePendingBindings();
            }
        }
    }
}

