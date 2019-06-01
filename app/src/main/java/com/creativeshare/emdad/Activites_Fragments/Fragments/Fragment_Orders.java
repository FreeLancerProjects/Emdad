package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.Adapters.User_Orders_Page_Adapter;
import com.creativeshare.emdad.R;
import com.google.android.material.tabs.TabLayout;


public class Fragment_Orders extends Fragment {

    private TabLayout tabLayout;
    private Home_Activity activity;
    private ViewPager viewPager;
    private User_Orders_Page_Adapter user_orders_page_adapter;


    public static Fragment_Orders newInstance() {
        return new Fragment_Orders();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        intitview(view);

        return view;


    }

    private void intitview(View view) {
        activity = (Home_Activity) getActivity();
        tabLayout = view.findViewById(R.id.tab_orders);
        viewPager = view.findViewById(R.id.pager);
        user_orders_page_adapter = new User_Orders_Page_Adapter(activity.getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(user_orders_page_adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}