package com.creativeshare.emdad.Activites_Fragments.Fragments;

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


public class Fragment_First_shipping_Transportation extends Fragment {
    private Button next;
    private Home_Activity activity;
    private ImageView next_img;
    private Preferences preferences;
    private String current_language;

    public static Fragment_First_shipping_Transportation newInstance() {

        return new Fragment_First_shipping_Transportation();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__first_shipping__transportation, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        activity = (Home_Activity) getActivity();
        preferences=Preferences.getInstance();
        current_language=preferences.getlang(activity);
        next = view.findViewById(R.id.next_shipping);
        next_img = view.findViewById(R.id.image_next);
        if(current_language.equals("ar")){
            next_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_left_arrow_previous));
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentshipping_second();
            }
        });
    }


}
