package com.michailpiskunov.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.michailpiskunov.myapplication.App;
import com.michailpiskunov.myapplication.R;
import com.michailpiskunov.myapplication.databinding.FragmentLocationListBinding;
import com.michailpiskunov.myapplication.viewmodel.LocationListViewModel;

import javax.inject.Inject;

public class LocationListFragment extends Fragment {

    @Inject
    LocationListViewModel viewModel;

    public LocationListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        App.getFragmentComponent(this).inject(this);

        FragmentLocationListBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_location_list,
                container,
                false);

        binding.setDataViewModel(viewModel);
        viewModel.updateAll();


        return binding.getRoot();
    }

}
