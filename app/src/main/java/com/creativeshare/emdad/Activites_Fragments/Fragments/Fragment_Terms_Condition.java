package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Home_Activity;
import com.creativeshare.emdad.Model.Information_Model;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.preferences.Preferences;
import com.creativeshare.emdad.remote.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Terms_Condition extends Fragment {
    private Home_Activity activity;
    private Preferences preferences;
    private String current_language,terms_condition=null;
    private ImageView back;
    private TextView terms;

    public static Fragment_Terms_Condition newInstance() {
        return new Fragment_Terms_Condition();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_terms_condition, container, false);
        intitview(view);
       terms_condition= get_terms_condition();
       if(terms_condition!=null){
           terms.setText(terms_condition);
       }
        return view;
    }



    private void intitview(View view) {
        preferences = Preferences.getInstance();
        activity = (Home_Activity) getActivity();
        current_language = preferences.getlang(activity);
        back = view.findViewById(R.id.back);
        terms=view.findViewById(R.id.terms_txt);
        if (current_language.equals("en")) {
            back.setRotation(180);
        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.Back();
            }
        });
    }
    private String get_terms_condition() {
        Api.getService().gettermscondition().enqueue(new Callback<Information_Model>() {
            @Override
            public void onResponse(Call<Information_Model> call, Response<Information_Model> response) {
                if(response.isSuccessful()){
                    if(!response.body().equals(null)){
                        if(current_language.equals("ar")){
                            terms_condition=response.body().getAr_content();
                        }
                        else{
                            terms_condition=response.body().getEn_content();
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<Information_Model> call, Throwable t) {
                Log.e("Error",t.getMessage());
            }
        });
        return terms_condition;
    }

}
