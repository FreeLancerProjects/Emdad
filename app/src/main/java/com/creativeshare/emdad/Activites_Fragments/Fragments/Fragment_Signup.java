package com.creativeshare.emdad.Activites_Fragments.Fragments;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;


public class Fragment_Signup extends Fragment {

    // TODO: Rename and change types and number of parameters
    public static Fragment_Signup newInstance() {
       return new Fragment_Signup();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_signup, container, false);
      return view;
    }


}
