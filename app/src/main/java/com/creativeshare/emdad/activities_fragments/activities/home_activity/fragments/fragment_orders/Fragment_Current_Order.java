package com.creativeshare.emdad.activities_fragments.activities.home_activity.fragments.fragment_orders;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.models.OrderDataModel;


public class Fragment_Current_Order extends Fragment {

    public static Fragment_Current_Order newInstance() {
        return new Fragment_Current_Order();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_current_order, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

    }

    public void setItemData(OrderDataModel.OrderModel orderModel, int adapterPosition) {

    }
}
