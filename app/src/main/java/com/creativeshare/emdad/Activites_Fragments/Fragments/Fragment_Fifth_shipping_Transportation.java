package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;

public class Fragment_Fifth_shipping_Transportation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private Button send, previous;
    private ImageView  previous_img;
    private Home_Activity activity;
    private String current_lang;
    private Preferences preferences;
    public static Fragment_Fifth_shipping_Transportation newInstance() {
       return new Fragment_Fifth_shipping_Transportation();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fifth_shipping__transportation, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        preferences= Preferences.getInstance();
        activity=(Home_Activity)getActivity();
        current_lang= preferences.getlang(activity);
        previous=view.findViewById(R.id.previous);
        previous_img = view.findViewById(R.id.image_previous);
        if (current_lang.equals("ar")) {
            previous_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_right_previous));

        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event



}
