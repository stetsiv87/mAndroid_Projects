package com.example.yura.navigationdrawer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yura.navigationdrawer.R;

/**
 * Created by Yura on 02.01.2017.
 */

public class First_Fragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     view = inflater.inflate(R.layout.first_layout,container,false);
        return view;
    }
}
