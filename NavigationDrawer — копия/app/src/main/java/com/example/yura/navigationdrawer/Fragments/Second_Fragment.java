package com.example.yura.navigationdrawer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yura.navigationdrawer.FoodAdapter;
import com.example.yura.navigationdrawer.R;

/**
 * Created by Yura on 02.01.2017.
 */

public class Second_Fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    FoodAdapter mFoodAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_layout,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recview);
      //  mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mFoodAdapter = new FoodAdapter(getActivity());
        mRecyclerView.setAdapter(mFoodAdapter);
        registerForContextMenu(mRecyclerView);

        return view;
    }
}
