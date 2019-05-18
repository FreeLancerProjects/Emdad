package com.creativeshare.emdad.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Current_Order;
import com.creativeshare.emdad.Activites_Fragments.Fragments.Fragment_Previous_Order;


public class User_Orders_Page_Adapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public User_Orders_Page_Adapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
               Fragment_Current_Order tab1 = new Fragment_Current_Order();
                return tab1;
            case 1:
              Fragment_Previous_Order tab2 = new Fragment_Previous_Order();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}