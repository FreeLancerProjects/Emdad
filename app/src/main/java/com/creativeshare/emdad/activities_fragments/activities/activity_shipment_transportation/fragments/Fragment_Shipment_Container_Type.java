package com.creativeshare.emdad.activities_fragments.activities.activity_shipment_transportation.fragments;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.activities_fragments.activities.activity_shipment_transportation.activity.ShipmentActivity;
import com.creativeshare.emdad.adapters.ShipmentContainersAdapterParent;
import com.creativeshare.emdad.models.ContainersModel;
import com.creativeshare.emdad.remote.Api;
import com.creativeshare.emdad.tags.Tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Shipment_Container_Type extends Fragment {

    private RecyclerView recView;
    private LinearLayoutManager manager;
    private TextView tv_type,tv_truck_number,tv_truck_size;
    private ShipmentContainersAdapterParent adapter;
    private ProgressBar progBar;
    private List<ContainersModel> containerModelList;
    private ShipmentActivity activity;
    private int container_id=-1;
    private String truck_number_id="",truck_size_id="", truck_type_id ="";



    public static Fragment_Shipment_Container_Type newInstance()
    {
        return new Fragment_Shipment_Container_Type();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shipment_container_type,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        containerModelList = new ArrayList<>();
        activity = (ShipmentActivity) getActivity();
        tv_type = view.findViewById(R.id.tv_type);
        tv_truck_number = view.findViewById(R.id.tv_truck_number);
        tv_truck_size = view.findViewById(R.id.tv_truck_size);

        progBar = view.findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ActivityCompat.getColor(activity,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);

        recView = view.findViewById(R.id.recView);
        manager = new LinearLayoutManager(activity);
        recView.setLayoutManager(manager);

        adapter = new ShipmentContainersAdapterParent(containerModelList,activity,this);
        recView.setAdapter(adapter);


        getContainers();
    }

    private void getContainers() {

        Api.getService(Tags.base_url)
                .getContainers()
                .enqueue(new Callback<List<ContainersModel>>() {
                    @Override
                    public void onResponse(Call<List<ContainersModel>> call, Response<List<ContainersModel>> response) {
                        progBar.setVisibility(View.GONE);
                        if (response.isSuccessful()&&response.body()!=null)
                        {
                            if (response.body().size()>0)
                            {
                                containerModelList.addAll(response.body());


                                adapter.notifyDataSetChanged();
                            }else
                                {
                                    recView.setVisibility(View.GONE);
                                }

                        }else
                        {


                            Toast.makeText(activity, getString(R.string.failed), Toast.LENGTH_SHORT).show();
                            try {
                                Log.e("Error_code",response.code()+"_"+response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ContainersModel>> call, Throwable t) {
                        try {
                            progBar.setVisibility(View.GONE);
                            Toast.makeText(activity, R.string.something, Toast.LENGTH_SHORT).show();
                            Log.e("Error",t.getMessage());
                        }catch (Exception e){}
                    }
                });
    }

    public boolean isDataOk()
    {

        if (!TextUtils.isEmpty(truck_type_id)&&
                !TextUtils.isEmpty(truck_number_id)&&
                !TextUtils.isEmpty(truck_size_id)&&
                container_id!=-1

        )
        {
            tv_type.setError(null);
            tv_truck_number.setError(null);
            tv_truck_size.setError(null);

            activity.saveContainerData(container_id, truck_type_id,truck_number_id,truck_size_id);
            return true;
        }else
            {


                if (TextUtils.isEmpty(truck_type_id))
                {
                    tv_type.setError(getString(R.string.field_req));
                }else
                    {
                        tv_type.setError(null);

                    }

                if (TextUtils.isEmpty(truck_number_id))
                {
                    tv_truck_number.setError(getString(R.string.field_req));
                }else
                {
                    tv_truck_number.setError(null);

                }
                if (TextUtils.isEmpty(truck_size_id))
                {
                    tv_truck_size.setError(getString(R.string.field_req));
                }else
                {
                    tv_truck_size.setError(null);

                }

                if (container_id == -1)
                {
                    Toast.makeText(activity, getString(R.string.ch_truck), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
    }
    public void setItemData(ContainersModel.Trans containerModel) {
        //container_id = containerModel.getId();
    }
}
