package com.creativeshare.emdad.activities_fragments.activities.home_activity.fragments.fragment_rental_order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.activities_fragments.activities.home_activity.activity.Home_Activity;
import com.creativeshare.emdad.adapters.Pager_Adapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;


public class Fragment_Rental_Orders extends Fragment {
    private LinearLayout ll_back;
    private ImageView image_back;
    private TextView tv_title;
    private TabLayout tab;
    private Home_Activity activity;
    private ViewPager pager;
    private Pager_Adapter pager_adapter;
    private List<Fragment> fragments;
    private List<String> titles;
    private String current_language;



    public static Fragment_Rental_Orders newInstance() {
        return new Fragment_Rental_Orders();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        initView(view);

        return view;


    }

    private void initView(View view) {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        activity = (Home_Activity) getActivity();
        Paper.init(activity);
        current_language = Paper.book().read("lang", Locale.getDefault().getLanguage());

        image_back = view.findViewById(R.id.image_back);
        ll_back = view.findViewById(R.id.ll_back);

        if (current_language.equals("ar"))
        {
            image_back.setRotation(180.0f);
        }


        tab = view.findViewById(R.id.tab);
        pager = view.findViewById(R.id.pager);
        tab.setupWithViewPager(pager);

        tv_title = view.findViewById(R.id.tv_title);
        tv_title.setText(getString(R.string.equipment_rental_orders));

        fragments.add(Fragment_Rental_Current_Order.newInstance());
        fragments.add(Fragment_Rental_Previous_Order.newInstance());

        titles.add(getString(R.string.current));
        titles.add(getString(R.string.previou));

        pager_adapter = new Pager_Adapter(getChildFragmentManager());
        pager_adapter.setFragments(fragments);
        pager_adapter.setTitles(titles);
        pager.setAdapter(pager_adapter);

        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });

    }
}