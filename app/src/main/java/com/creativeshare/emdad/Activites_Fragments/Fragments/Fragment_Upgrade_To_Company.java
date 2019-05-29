package com.creativeshare.emdad.Activites_Fragments.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;

public class Fragment_Upgrade_To_Company extends Fragment {

    public static Fragment_Upgrade_To_Company newInstance() {
       return new Fragment_Upgrade_To_Company();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view= inflater.inflate(R.layout.fragment_upgrade_to_company, container, false);
    return view;
    }

}
