package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Login_Activity;
import com.creativeshare.emdad.R;


public class Fragment_Login extends Fragment {
    private Button login;
    private TextView skip;
    private Login_Activity login_activity;

    public static Fragment_Login newInstance() {

        return new Fragment_Login();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_, container, false);
        intitview(view);
        return view;
    }

    private void intitview(View view) {
        login_activity = (Login_Activity) getActivity();
        login = view.findViewById(R.id.bt_login);
        skip=view.findViewById(R.id.skip);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_activity.openHome();
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_activity.skip();
            }
        });
    }


}
