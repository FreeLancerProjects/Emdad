package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;


public class Fragment_main extends Fragment {
    private LinearLayout water,shipping_and_transportation,equipment,otherservices;
    Home_Activity home_activity;

    public static Fragment_main newInstance() {
        return new Fragment_main();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        home_activity = (Home_Activity) getActivity();
        water = view.findViewById(R.id.card_water);
        shipping_and_transportation = view.findViewById(R.id.card_shipping_and_transportation);
        equipment = view.findViewById(R.id.card_equipment);
        otherservices = view.findViewById(R.id.card_other_services);
        water.setBackgroundResource(R.drawable.card1);
        shipping_and_transportation.setBackgroundResource(R.drawable.card2);
        equipment.setBackgroundResource(R.drawable.card3);
        otherservices.setBackgroundResource(R.drawable.card4);
        shipping_and_transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_activity.DisplayFragmentshipping_main();
                home_activity.DisplayFragmentshipping_First();
            }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home_activity.DisplayFragmentWater();
            }
        });
    }


}
