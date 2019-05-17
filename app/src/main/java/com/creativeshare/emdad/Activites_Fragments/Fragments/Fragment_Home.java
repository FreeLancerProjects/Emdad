package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;

import java.util.Locale;


public class Fragment_Home extends Fragment {
    private AHBottomNavigation bottomNavigationView;
    // private Preferences preferences;
    private Home_Activity activity;
    private TextView tv_title;
    private ImageView back;
    private String current_lang;
    private Preferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //preferences = Preferences.getInstance();
        View view = inflater.inflate(R.layout.fragment_home, container, false);

       intitview(view);

        setUpBottomNav();

        return view;
    }

    private void intitview(View view) {
        preferences=Preferences.getInstance();
        activity = (Home_Activity) getActivity();
        current_lang = preferences.getlang(activity);
        tv_title = view.findViewById(R.id.tv_title);
        back=view.findViewById(R.id.back_home);
        bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        if (current_lang.equals("en")) {
            back.setRotation(180);
        }

    }

    public static Fragment_Home newInstance() {
        return new Fragment_Home();
    }


    private void setUpBottomNav() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.home, R.drawable.ic_home, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.orders, R.drawable.ic_orders, R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.accountِ, R.drawable.ic_user, R.color.colorPrimary);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.more, R.drawable.ic_more, R.color.colorPrimary);
        bottomNavigationView.addItem(item1);
        bottomNavigationView.addItem(item2);
        bottomNavigationView.addItem(item3);
        bottomNavigationView.addItem(item4);
        bottomNavigationView.setAccentColor(ContextCompat.getColor(activity, R.color.white));
        bottomNavigationView.setDefaultBackgroundColor(ContextCompat.getColor(activity, R.color.yellow1));
        bottomNavigationView.setInactiveColor(ContextCompat.getColor(activity, R.color.white));
        bottomNavigationView.setForceTint(true);
        bottomNavigationView.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigationView.setColored(false);

        bottomNavigationView.setCurrentItem(0);


        bottomNavigationView.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0:
                        // activity.DisplayFragmentMain();
                        break;
                    case 1:
                        // activity.DisplayFragmentOrders();
                        break;
                    case 2:
                        //   activity.DisplayFragmentOffers();

                        break;
                    case 3:
                        //  activity.DisplayFragmentProfile();
                        break;


                }
                return false;
            }
        });
    }

   /* public void UpdateAHBottomNavigationPosition(int pos) {

        if (pos == 0) {
            tv_title.setText(getString(R.string.home));
        } else if (pos == 1) {
            tv_title.setText(getString(R.string.needs));

        } else if (pos == 2) {
            tv_title.setText(getString(R.string.offers));

        } else if (pos == 3) {
            tv_title.setText(getString(R.string.accountِ));

        } else if (pos == 4) {
            tv_title.setText(getString(R.string.more));

        }
        bottomNavigationView.setSelectedBackgroundVisible(true);

        bottomNavigationView.setCurrentItem(pos, false);
    }*/
}