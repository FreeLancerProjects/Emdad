package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class Fragment_Profile extends Fragment {
    private CircleImageView circleImageView;

    public static Fragment_Profile newInstance() {

        return new Fragment_Profile();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        circleImageView=view.findViewById(R.id.accout_img);
        circleImageView.setImageResource(R.drawable.ic_photographer);
    }


}
