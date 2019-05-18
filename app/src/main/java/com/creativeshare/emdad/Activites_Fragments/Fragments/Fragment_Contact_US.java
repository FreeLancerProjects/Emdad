package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Contact_US.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Contact_US#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Contact_US extends Fragment {

    private Home_Activity activity;
    private Preferences preferences;
    private EditText name, email, message;
    private Button send;
    private ImageView back;
    private String current_language;
    public static Fragment_Contact_US newInstance() {
        return new Fragment_Contact_US();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        intitview(view);

        // Inflate the layout for this fragment
        return view;
    }

    private void intitview(final View view) {
        activity = (Home_Activity) getActivity();
        preferences = Preferences.getInstance();
        current_language=preferences.getlang(activity);
        back = (ImageView) view.findViewById(R.id.back1);
        name = (EditText) view.findViewById(R.id.name_contact);
        email = (EditText) view.findViewById(R.id.email_contact);
        message = (EditText) view.findViewById(R.id.message_contact);
        send = (Button) view.findViewById(R.id.send);
        if (current_language.equals("en")) {
            back.setRotation(180);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });


    }
}