package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_seconed_shipping_Transportation.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_seconed_shipping_Transportation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_seconed_shipping_Transportation extends Fragment {
    private Button next;
    private TextView txt_code_phone, txt_phone;
    private Home_Activity activity;
    private String current_lang;

    public static Fragment_seconed_shipping_Transportation newInstance() {
        return new Fragment_seconed_shipping_Transportation();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_seconed_shipping_transportation, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        current_lang= Locale.getDefault().getLanguage();
        activity = (Home_Activity) getActivity();
        next = view.findViewById(R.id.next_shipping);
        txt_code_phone = view.findViewById(R.id.txt_phone_num_code);
        txt_phone = view.findViewById(R.id.txt_phone_num);
        if(current_lang.equals("ar")){
            txt_code_phone.setBackground(getResources().getDrawable(R.drawable.text_right_shape));
            txt_phone.setBackground(getResources().getDrawable(R.drawable.text_left_shape));
        }
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentshipping_Third();
            }
        });
    }
}
