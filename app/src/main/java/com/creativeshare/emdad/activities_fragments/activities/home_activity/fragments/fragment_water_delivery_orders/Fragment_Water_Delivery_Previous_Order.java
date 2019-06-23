package com.creativeshare.emdad.activities_fragments.activities.home_activity.fragments.fragment_water_delivery_orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;


public class Fragment_Water_Delivery_Previous_Order extends Fragment {

    public static Fragment_Water_Delivery_Previous_Order newInstance() {
       return new Fragment_Water_Delivery_Previous_Order();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_water_delivery_previous_order, container, false);
      return view;
    }


}
