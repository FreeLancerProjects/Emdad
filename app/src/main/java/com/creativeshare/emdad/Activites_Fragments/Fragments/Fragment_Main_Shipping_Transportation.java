package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;
import com.xw.repo.BubbleSeekBar;

import java.util.Locale;


public class Fragment_Main_Shipping_Transportation extends Fragment {
private BubbleSeekBar bubbleSeekBar;
private ImageView back;
private String current_lang;
private Preferences preferences;
private Home_Activity activity;
    // TODO: Rename and change types and number of parameters
    public static Fragment_Main_Shipping_Transportation newInstance() {
        return new Fragment_Main_Shipping_Transportation();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view= inflater.inflate(R.layout.fragment_main_shipping__transportation, container, false);
     intitview(view);
     return view;
    }

    private void intitview(View view) {
        activity=(Home_Activity)getActivity();
        preferences=Preferences.getInstance();
        current_lang= preferences.getlang(activity);
        bubbleSeekBar=view.findViewById(R.id.buble);
        back=view.findViewById(R.id.back);
        update_bar(0);
        if(current_lang.equals("en")){
            back.setRotation(180);}
    }


    public void update_bar(float i) {
        bubbleSeekBar.setProgress(i);
    }
    public void update_bar() {
        bubbleSeekBar.setProgress(bubbleSeekBar.getProgressFloat()-25);
    }
}
