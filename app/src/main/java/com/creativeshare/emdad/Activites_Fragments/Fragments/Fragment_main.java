package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.Adapters.SlidingImage_Adapter;
import com.creativeshare.emdad.Model.Slider_Model;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.remote.Api;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_main extends Fragment {
    private LinearLayout water,shipping_and_transportation,equipment,otherservices;
    private ViewPager mPager;
    private TabLayout indicator;
    private Home_Activity activity;
    private SlidingImage_Adapter slidingImage__adapter;
    private ProgressBar progBar;
    private int current_page = 0,NUM_PAGES;
    public static Fragment_main newInstance() {
        return new Fragment_main();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        intitview(view);
        get_slider();
        return view;
    }

    private void intitview(View view) {
        activity = (Home_Activity) getActivity();
        water = view.findViewById(R.id.card_water);
        shipping_and_transportation = view.findViewById(R.id.card_shipping_and_transportation);
        equipment = view.findViewById(R.id.card_equipment);
        otherservices = view.findViewById(R.id.card_other_services);
        mPager = view.findViewById(R.id.view1);
        indicator = view.findViewById(R.id.tab1);
        progBar = view.findViewById(R.id.progBarAds);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        shipping_and_transportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentshipping_main();
                activity.DisplayFragmentshipping_First();
            }
        });
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentWater();
            }
        });
    }
    private void get_slider() {
        Api.getService().get_slider().enqueue(new Callback<Slider_Model>() {
            @Override
            public void onResponse(Call<Slider_Model> call, Response<Slider_Model> response) {
                progBar.setVisibility(View.GONE);
                if(response.isSuccessful()){
                    if(response.body().getData().size()>0){
                        NUM_PAGES=response.body().getData().size();
                        slidingImage__adapter = new SlidingImage_Adapter(activity,response.body().getData());
                        mPager.setAdapter(slidingImage__adapter);
                        indicator.setupWithViewPager(mPager);
                    }
                    else {

                        mPager.setVisibility(View.GONE);
                    }
                }
                else if (response.code() == 404) {

                    mPager.setVisibility(View.GONE);
                } else {
                    mPager.setVisibility(View.GONE);
                    try {
                        Log.e("Error_code", response.code() + "_" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<Slider_Model> call, Throwable t) {
                Log.e("Error", t.getMessage());
                progBar.setVisibility(View.GONE);
                mPager.setVisibility(View.GONE);
            }
        });

    }


}
