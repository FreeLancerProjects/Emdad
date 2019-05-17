package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_more.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_more#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_more extends Fragment {
    private ImageView call,terms,bank_img,logout_img,lang_img,about;
    private LinearLayout logout;
    private Home_Activity activity;
    private Preferences preferences;
    public static Fragment_more newInstance() {

        return new Fragment_more();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_more, container, false);
       intitview(view);
       return view;
    }

    private void intitview(View view) {
        call =  view.findViewById(R.id.call);
        terms = view.findViewById(R.id.term);
        bank_img =  view.findViewById(R.id.bank_img);
        logout_img =  view.findViewById(R.id.logout_img);
        lang_img =  view.findViewById(R.id.lang);
        about=view.findViewById(R.id.about);
        logout =  view.findViewById(R.id.logout);
        activity = (Home_Activity) getActivity();
        preferences = Preferences.getInstance();
        activity = (Home_Activity) getActivity();
        if (preferences.getlang(activity).equals("ar")) {
            call.setRotation(180);
            terms.setRotation(180);
            bank_img.setRotation(180);
            lang_img.setRotation(180);
            about.setRotation(180);
        } else {
            logout_img.setRotation(180);
        }
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentAbout();
            }
        });
    }


}
