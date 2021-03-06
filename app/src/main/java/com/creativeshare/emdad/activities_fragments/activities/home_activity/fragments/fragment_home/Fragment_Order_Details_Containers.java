package com.creativeshare.emdad.activities_fragments.activities.home_activity.fragments.fragment_home;

import android.app.ProgressDialog;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.activities_fragments.activities.home_activity.activity.Home_Activity;
import com.creativeshare.emdad.models.ContainersOrderDetailsModel;
import com.creativeshare.emdad.models.UserModel;
import com.creativeshare.emdad.preferences.Preferences;
import com.creativeshare.emdad.remote.Api;
import com.creativeshare.emdad.share.Common;
import com.creativeshare.emdad.tags.Tags;
import com.google.android.material.appbar.AppBarLayout;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import io.paperdb.Paper;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Order_Details_Containers extends Fragment {
    private static final String TAG = "ORDER_ID";
    private static final String TAG2 = "PRICE";

    private ImageView image_back;
    private LinearLayout ll_back,ll,ll_order_state;
    private CircleImageView image;
    private TextView tv_client_name,tv_order_num,tv_size,tv_address,tv_type,tv_cost;
    private ProgressBar progBar;
    private CoordinatorLayout cord_layout;
    private AppBarLayout app_bar;
    private Button btn_done;
    private String current_language;
    private UserModel userModel;
    private Preferences preferences;
    private Home_Activity activity;
    private String price;
    private ContainersOrderDetailsModel containersOrderDetailsModel;
    ////////////////
    private ImageView image1,image5;
    private TextView tv1, tv5, tv_order_id;
    private View view1;

    public static Fragment_Order_Details_Containers newInstance(int order_id, String price)
    {
        Bundle bundle = new Bundle();
        bundle.putInt(TAG,order_id);
        bundle.putString(TAG2,price);
        Fragment_Order_Details_Containers fragment_order_details_containers = new Fragment_Order_Details_Containers();
        fragment_order_details_containers.setArguments(bundle);
        return fragment_order_details_containers;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_details_containers,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        activity = (Home_Activity) getActivity();
        preferences = Preferences.getInstance();
        userModel = preferences.getUserData(activity);
        Paper.init(activity);
        current_language = Paper.book().read("lang", Locale.getDefault().getLanguage());
        image_back = view.findViewById(R.id.image_back);
        if (current_language.equals("ar")||current_language.equals("ur")){
            image_back.setRotation(180.0f);
        }
        ll_back = view.findViewById(R.id.ll_back);
        ll = view.findViewById(R.id.ll);
        image = view.findViewById(R.id.image);
        tv_client_name = view.findViewById(R.id.tv_client_name);
        tv_order_num = view.findViewById(R.id.tv_order_num);
        tv_size = view.findViewById(R.id.tv_size);
        tv_address = view.findViewById(R.id.tv_address);
        tv_type = view.findViewById(R.id.tv_type);

        progBar = view.findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(activity,R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
        cord_layout = view.findViewById(R.id.cord_layout);
        tv_cost = view.findViewById(R.id.tv_cost);
        app_bar = view.findViewById(R.id.app_bar);
        btn_done = view.findViewById(R.id.btn_done);
        ll_order_state = view.findViewById(R.id.ll_order_state);
        image1 = view.findViewById(R.id.image1);
        image5 = view.findViewById(R.id.image5);
        tv1 = view.findViewById(R.id.tv1);
        tv5 = view.findViewById(R.id.tv5);
        tv_order_id = view.findViewById(R.id.tv_order_id);
        view1 = view.findViewById(R.id.view1);


        app_bar.addOnOffsetChangedListener(new AppBarLayout.BaseOnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                int total_range = appBarLayout.getTotalScrollRange();
                if ((total_range+i)>60)
                {
                    image.setVisibility(View.VISIBLE);
                    tv_client_name.setVisibility(View.VISIBLE);
                }else
                    {
                        image.setVisibility(View.GONE);
                        tv_client_name.setVisibility(View.GONE);
                    }
            }
        });

        Bundle bundle = getArguments();
        if (bundle!=null)
        {
            int order_id = bundle.getInt(TAG);
            price = bundle.getString(TAG2);
            getOrderData(order_id);
        }

        ll_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FinishOrder();
            }
        });


    }

    private void getOrderData(int order_id) {

        Api.getService(Tags.base_url)
                .getContainersOrderDetails(order_id,Tags.CONTAINERS_ORDER)
                .enqueue(new Callback<ContainersOrderDetailsModel>() {
                    @Override
                    public void onResponse(Call<ContainersOrderDetailsModel> call, Response<ContainersOrderDetailsModel> response) {
                        if (response.isSuccessful())
                        {
                            progBar.setVisibility(View.GONE);
                            updateUI(response.body());
                        }else
                        {
                            try {
                                Log.e("code_error",response.code()+"_"+response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(activity, getString(R.string.failed), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ContainersOrderDetailsModel> call, Throwable t) {
                        try {
                            Toast.makeText(activity, getString(R.string.something), Toast.LENGTH_SHORT).show();
                            Log.e("error",t.getMessage());

                        }catch (Exception e)
                        {

                        }

                    }
                });

    }

    private void updateUI(ContainersOrderDetailsModel containersOrderDetailsModel) {
        this.containersOrderDetailsModel = containersOrderDetailsModel;

        if (userModel.getUser().getCompany_information()==null)
        {
            Picasso.with(activity).load(Uri.parse(Tags.base_url+containersOrderDetailsModel.getOrder().getTo_user_image())).placeholder(R.drawable.logo_512).fit().into(image);
            tv_client_name.setText(containersOrderDetailsModel.getOrder().getTo_user_name());
            ll.setVisibility(View.GONE);

        }else
            {
                Picasso.with(activity).load(Uri.parse(Tags.base_url+containersOrderDetailsModel.getOrder().getFrom_user_image())).placeholder(R.drawable.logo_512).fit().into(image);
                tv_client_name.setText(containersOrderDetailsModel.getOrder().getFrom_user_name());
                ll.setVisibility(View.VISIBLE);

            }

        cord_layout.setVisibility(View.VISIBLE);


        tv_order_num.setText(String.format("%s %s","#",containersOrderDetailsModel.getOrder_details().getOrder_id()));
        tv_address.setText(containersOrderDetailsModel.getOrder_details().getAddress());
        tv_cost.setText(String.format("%s %s",price,getString(R.string.sar)));

        if (current_language.equals("ar")||current_language.equals("ur"))
        {
            tv_type.setText(containersOrderDetailsModel.getOrder_details().getAr_type());
            tv_size.setText(containersOrderDetailsModel.getOrder_details().getAr_size());
        }else
        {
            tv_type.setText(containersOrderDetailsModel.getOrder_details().getEn_type());
            tv_size.setText(containersOrderDetailsModel.getOrder_details().getEn_size());

        }



        updateStepView(Integer.parseInt(containersOrderDetailsModel.getOrder().getOrder_status()));

        tv_order_id.setText(String.format("%s %s","#",containersOrderDetailsModel.getOrder_details().getOrder_id()));

        if (userModel.getUser().getCompany_information()==null)
        {
            ll_order_state.setVisibility(View.VISIBLE);

        }else
            {
                ll_order_state.setVisibility(View.GONE);

            }

        if (containersOrderDetailsModel.getOrder().getOrder_status().equals("2"))
        {
            btn_done.setVisibility(View.GONE);
        }
    }


    private void FinishOrder() {
        final ProgressDialog dialog = Common.createProgressDialog(activity,getString(R.string.wait));
        dialog.setCancelable(false);
        dialog.show();

        Api.getService(Tags.base_url)
                .companyFinishOrder(containersOrderDetailsModel.getOrder_details().getOrder_id())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        dialog.dismiss();
                        if (response.isSuccessful())
                        {
                            Toast.makeText(activity, getString(R.string.suc), Toast.LENGTH_SHORT).show();
                            activity.Back();
                            activity.refreshFragmentOrder();
                        }else
                        {
                            try {
                                Log.e("code_error",response.code()+"_"+response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(activity, getString(R.string.failed), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                        try {
                            Toast.makeText(activity, getString(R.string.something), Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            Log.e("error",t.getMessage());
                        }catch (Exception e)
                        {

                        }


                    }
                });

    }


    public void updateStepView(int completePosition) {
        switch (completePosition) {

            case 1:
                image1.setBackgroundResource(R.drawable.step_green_circle);
                image1.setImageResource(R.drawable.step_green_true);
                view1.setBackgroundColor(ContextCompat.getColor(activity, R.color.done));
                tv1.setTextColor(ContextCompat.getColor(activity, R.color.colorPrimary));

                break;
            case 2:
                image1.setBackgroundResource(R.drawable.step_green_circle);
                image1.setImageResource(R.drawable.step_green_true);
                view1.setBackgroundColor(ContextCompat.getColor(activity, R.color.done));
                tv1.setTextColor(ContextCompat.getColor(activity, R.color.colorPrimary));

                image5.setBackgroundResource(R.drawable.step_green_circle);
                image5.setImageResource(R.drawable.step_green_heart);
                tv5.setTextColor(ContextCompat.getColor(activity, R.color.colorPrimary));


        }
    }

   }
