package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_First_shipping_Transportation.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_First_shipping_Transportation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_First_shipping_Transportation extends Fragment {
private Button next;
Home_Activity activity;
    public static Fragment_First_shipping_Transportation newInstance() {

        return new Fragment_First_shipping_Transportation();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view= inflater.inflate(R.layout.fragment__first_shipping__transportation, container, false);
      intitview(view);
      return view;
    }

    private void intitview(View view) {
        activity=(Home_Activity)getActivity();
        next=view.findViewById(R.id.next_shipping);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentshipping_second();
            }
        });
    }


}
