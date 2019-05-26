package com.creativeshare.emdad.Activites_Fragments.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;

public class Fragment_Connecting_Water extends Fragment {

    public static Fragment_Connecting_Water newInstance() {
       return new Fragment_Connecting_Water();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
     View view= inflater.inflate(R.layout.fragment_connecting__water, container, false);
     return view;
    }


}
