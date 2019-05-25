package com.creativeshare.emdad.Activites_Fragments.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;


public class Fragment_Rental_Of_Equipment extends Fragment {


    // TODO: Rename and change types and number of parameters
    public static Fragment_Rental_Of_Equipment newInstance() {
       return new Fragment_Rental_Of_Equipment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_rental__of__equipment, container, false);
       return view;
    }

}
