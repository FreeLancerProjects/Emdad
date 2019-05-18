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
import android.widget.TextView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;

import java.util.Locale;


public class Fragment_Third_shipping_Transportation extends Fragment {
    private TextView txt_code_phone, txt_phone;
    private Button previous,next;
    private ImageView next_img,previous_img;
    private Home_Activity activity;
    private Preferences preferences;
    private String current_lang;


    // TODO: Rename and change types and number of parameters
    public static Fragment_Third_shipping_Transportation newInstance() {
       return new Fragment_Third_shipping_Transportation();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_third_shipping__transportation, container, false);
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
        txt_code_phone = view.findViewById(R.id.txt_phone_num_code);
        txt_phone = view.findViewById(R.id.txt_phone_num);
        if(current_lang.equals("ar")){
            txt_code_phone.setBackground(getResources().getDrawable(R.drawable.text_right_shape));
            txt_phone.setBackground(getResources().getDrawable(R.drawable.text_left_shape));
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
