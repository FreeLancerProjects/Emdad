package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;


public class Fragment_Fourth_shipping_Transpoortation extends Fragment {

    public static Fragment_Fourth_shipping_Transpoortation newInstance() {
       return new Fragment_Fourth_shipping_Transpoortation();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_fourth_shipping__transpoortation, container, false);
       return view;
    }


}
