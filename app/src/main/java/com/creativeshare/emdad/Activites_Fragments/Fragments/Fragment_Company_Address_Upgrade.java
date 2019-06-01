package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;


public class Fragment_Company_Address_Upgrade extends Fragment {

    public static Fragment_Company_Address_Upgrade newInstance() {
     return new Fragment_Company_Address_Upgrade();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_company__address__upgrade, container, false);
        return view;
    }

}
