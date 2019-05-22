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


public class Fragment_Fourth_shipping_Transpoortation extends Fragment {
    private Button previous,next;
    private ImageView next_img,previous_img;
    private Home_Activity activity;
    private Preferences preferences;
    private String current_lang;
    public static Fragment_Fourth_shipping_Transpoortation newInstance() {
       return new Fragment_Fourth_shipping_Transpoortation();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_fourth_shipping__transpoortation, container, false);
       intitview(view);
       return view;
    }

    private void intitview(View view) {
        preferences=Preferences.getInstance();
        activity=(Home_Activity)getActivity();
        current_lang= preferences.getlang(activity);
        previous=view.findViewById(R.id.previous);
        next=view.findViewById(R.id.next_shipping);
        next_img=view.findViewById(R.id.image_next);
        previous_img=view.findViewById(R.id.image_previous);

        if(current_lang.equals("ar")){

            previous_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_right_previous));
            next_img.setImageDrawable(getResources().getDrawable(R.drawable.ic_left_arrow_previous));
        }
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });
    }


}
