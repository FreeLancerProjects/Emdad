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
 * {@link Fragment_Equipment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Equipment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Equipment extends Fragment {

    public static Fragment_Equipment newInstance() {
      return new Fragment_Equipment();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment_equipment, container, false);
      return view;
    }

}
