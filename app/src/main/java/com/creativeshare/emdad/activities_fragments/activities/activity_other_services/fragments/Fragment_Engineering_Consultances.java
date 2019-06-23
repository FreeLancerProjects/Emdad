package com.creativeshare.emdad.activities_fragments.activities.activity_other_services.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.creativeshare.emdad.R;

public class Fragment_Engineering_Consultances extends Fragment {
    public static Fragment_Engineering_Consultances newInstance() {
        return new Fragment_Engineering_Consultances();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_engineering_consultances, container, false);
        return view;
    }
}
