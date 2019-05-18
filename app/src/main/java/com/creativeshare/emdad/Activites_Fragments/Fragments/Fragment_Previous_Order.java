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
 * {@link Fragment_Previous_Order.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Previous_Order#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Previous_Order extends Fragment {

    public static Fragment_Previous_Order newInstance() {
       return new Fragment_Previous_Order();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_fragment__previous__order, container, false);
      return view;
    }


}
