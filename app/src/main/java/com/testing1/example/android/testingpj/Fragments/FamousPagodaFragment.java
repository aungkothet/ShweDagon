package com.testing1.example.android.testingpj.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.testing1.example.android.testingpj.Adapters.FamousThingAdapter;
import com.testing1.example.android.testingpj.Items.FamousThingsItem;
import com.testing1.example.android.testingpj.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 3/12/2016.
 */
public class FamousPagodaFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FamousPagodaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_famous_pagodas, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.famous_pagoda_list);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FamousThingAdapter(getActivity().getApplicationContext(),getData());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        return view;
    }

    public List<FamousThingsItem> getData() {
        List<FamousThingsItem> data = new ArrayList<>();

        String[] famousPagoda = getActivity().getApplication().getResources().getStringArray(R.array.famour_thing_pagodas);

        for (int i = 0; i < famousPagoda.length; i++) {
            FamousThingsItem current = new FamousThingsItem(getActivity().getApplicationContext());
            current.itemName = famousPagoda[i];
            data.add(current);
        }

        return data;
    }
}
