package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Orders.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Orders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Orders extends Fragment {

    public static Fragment_Orders newInstance() {
     return new Fragment_Orders();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_orders, container, false);
       return view;
    }


}
