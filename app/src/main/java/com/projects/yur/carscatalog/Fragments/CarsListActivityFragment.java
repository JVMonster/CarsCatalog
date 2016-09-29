package com.projects.yur.carscatalog.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.projects.yur.carscatalog.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CarsListActivityFragment extends Fragment {

    public CarsListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cars_list, container, false);
    }
}
