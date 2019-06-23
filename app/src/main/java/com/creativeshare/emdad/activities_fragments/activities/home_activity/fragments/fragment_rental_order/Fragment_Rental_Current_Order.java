package com.creativeshare.emdad.activities_fragments.activities.home_activity.fragments.fragment_rental_order;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.creativeshare.emdad.R;


public class Fragment_Rental_Current_Order extends Fragment {

    public static Fragment_Rental_Current_Order newInstance() {
        return new Fragment_Rental_Current_Order();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_rental_current_order, container, false);
        return view;
    }
}
