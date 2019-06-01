package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;


public class Fragment_Business_Register_Upgrade extends Fragment {
private Button next;
private Home_Activity activity;
    public static Fragment_Business_Register_Upgrade newInstance() {
     return new Fragment_Business_Register_Upgrade();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view=inflater.inflate(R.layout.fragment_business_register_upgrade, container, false);
    intitview(view);
    return view;
    }

    private void intitview(View view) {
        activity=(Home_Activity)getActivity();
        next=view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentAddressUpgrade();
            }
        });
    }

}
