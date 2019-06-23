package com.creativeshare.emdad.activities_fragments.activities.home_activity.fragments.fragment_home;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.activities_fragments.activities.activity_other_services.OtherActivity;
import com.creativeshare.emdad.activities_fragments.activities.activity_shipment_transportation.activity.ShipmentActivity;
import com.creativeshare.emdad.activities_fragments.activities.home_activity.activity.Home_Activity;
import com.creativeshare.emdad.adapters.Slider_Adapter;
import com.creativeshare.emdad.models.SliderDataModel;
import com.creativeshare.emdad.models.UserModel;
import com.creativeshare.emdad.preferences.Preferences;
import com.creativeshare.emdad.remote.Api;
import com.creativeshare.emdad.share.Common;
import com.creativeshare.emdad.tags.Tags;
import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_main extends Fragment {
    private LinearLayout ll_water_delivery,ll_shipment,ll_rental,ll_other_services;
    private ViewPager pager;
    private TabLayout tab;
    private Home_Activity activity;
    private TextView tv_no_ads;
    private Slider_Adapter slider_adapter;
    private ProgressBar progBar;
    private TimerTask timerTask;
    private Timer timer;
    private Preferences preferences;
    private UserModel userModel;
    public static Fragment_main newInstance() {
        return new Fragment_main();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        activity = (Home_Activity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        pager = view.findViewById(R.id.pager);
        tab = view.findViewById(R.id.tab);
        progBar = view.findViewById(R.id.progBar);
        tv_no_ads = view.findViewById(R.id.tv_no_ads);
        tab.setupWithViewPager(pager);

        ll_water_delivery = view.findViewById(R.id.ll_water_delivery);
        ll_shipment = view.findViewById(R.id.ll_shipment);
        ll_rental = view.findViewById(R.id.ll_rental);
        ll_other_services = view.findViewById(R.id.ll_other_services);

        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity, R.color.colorPrimary), PorterDuff.Mode.SRC_IN);


        ll_water_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentWaterDeliveryReserve();
            }
        });

        ll_shipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userModel!=null)
                {
                    Intent intent = new Intent(activity, ShipmentActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else
                    {
                        Common.CreateUserNotSignInAlertDialog(activity);
                    }

            }
        });

        ll_rental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DisplayFragmentEquipments();
            }
        });

        ll_other_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userModel!=null)
                {
                    Intent intent = new Intent(activity, OtherActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else
                {
                    Common.CreateUserNotSignInAlertDialog(activity);
                }



            }
        });



        getSlider();
    }

    private void getSlider() {
        Api.getService(Tags.base_url)
                .getSliders()
                .enqueue(new Callback<SliderDataModel>() {
                    @Override
                    public void onResponse(Call<SliderDataModel> call, Response<SliderDataModel> response) {
                        progBar.setVisibility(View.GONE);
                        if (response.isSuccessful()&&response.body()!=null&&response.body().getData()!=null)
                        {
                            updateUI(response.body());
                        }else
                            {
                                if (response.code() == 404)
                                {
                                    tv_no_ads.setVisibility(View.VISIBLE);
                                }
                                try {
                                    Log.e("error_code",response.code()+"_"+response.errorBody().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    }

                    @Override
                    public void onFailure(Call<SliderDataModel> call, Throwable t) {
                        try {
                            progBar.setVisibility(View.GONE);
                            Toast.makeText(activity, getString(R.string.something), Toast.LENGTH_SHORT).show();
                            Log.e("Error",t.getMessage());
                        }catch (Exception e){}
                    }
                });
    }

    private void updateUI(SliderDataModel sliderDataModel) {

        if (sliderDataModel.getData().size()>1)
        {
            slider_adapter = new Slider_Adapter(activity,sliderDataModel.getData());
            pager.setAdapter(slider_adapter);
            timerTask = new MyTimerTask();
            timer = new Timer();
            timer.scheduleAtFixedRate(timerTask,6000,6000);

            for (int i = 0 ; i<sliderDataModel.getData().size()-1;i++)
            {
                View view = ((ViewGroup)tab.getChildAt(0)).getChildAt(i);
                ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                params.setMargins(5,0,5,0);
                tab.requestLayout();

            }

        }else
            {
                slider_adapter = new Slider_Adapter(activity,sliderDataModel.getData());
                pager.setAdapter(slider_adapter);
            }
    }


    private class MyTimerTask extends TimerTask{
        @Override
        public void run() {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (pager.getCurrentItem()<pager.getAdapter().getCount()-1)
                    {
                        pager.setCurrentItem(pager.getCurrentItem()+1);
                    }else
                        {
                            pager.setCurrentItem(0);
                        }
                }
            });
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer!=null)
        {
            timer.purge();
            timer.cancel();
        }

        if (timerTask!=null)
        {
            timerTask.cancel();
        }


    }
}
