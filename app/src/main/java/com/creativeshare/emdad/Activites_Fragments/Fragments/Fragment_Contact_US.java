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
 * {@link Fragment_Contact_US.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Contact_US#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Contact_US extends Fragment {

    public static Fragment_Contact_US newInstance() {
      return new Fragment_Contact_US();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view= inflater.inflate(R.layout.fragment_contact_us, container, false);
     return view;
    }


}
