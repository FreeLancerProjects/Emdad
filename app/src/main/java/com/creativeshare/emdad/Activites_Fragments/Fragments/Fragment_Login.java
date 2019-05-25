package com.creativeshare.emdad.Activites_Fragments.Fragments;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.creativeshare.emdad.Activites_Fragments.Activites.Login_Activity;
import com.creativeshare.emdad.Model.UserModel;
import com.creativeshare.emdad.R;
import com.creativeshare.emdad.Share.Common;
import com.creativeshare.emdad.remote.Api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Login extends Fragment {
    private Button login;
    private TextView skip,newuser;
    private EditText useremail, userpass;
    private ProgressBar progBar;
    private String email, pass;
    private Login_Activity login_activity;

    public static Fragment_Login newInstance() {

        return new Fragment_Login();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_, container, false);
        intitview(view);
        return view;
    }

    private void intitview(final View view) {
        login_activity = (Login_Activity) getActivity();
        login = view.findViewById(R.id.bt_login);
        skip = view.findViewById(R.id.skip);
        newuser=view.findViewById(R.id.newuser);
        useremail = view.findViewById(R.id.email_login);
        userpass = view.findViewById(R.id.password_login);
        progBar = view.findViewById(R.id.progBar);
        progBar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(login_activity, R.color.yellow1), PorterDuff.Mode.SRC_IN);
        progBar.setVisibility(View.GONE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(view);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_activity.skip();
            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Common.Createsignup_chooser(login_activity);            }
        });
    }

    private void login(View view) {
        progBar.setVisibility(View.VISIBLE);
        email = useremail.getText().toString();
        pass = userpass.getText().toString();
        if (email.isEmpty() || !Common.isValidMail(email) || pass.isEmpty()) {
            progBar.setVisibility(View.GONE);
            if (email.isEmpty() || !Common.isValidMail(email)) {
                useremail.setError("");
            }
            if (pass.isEmpty()) {
                userpass.setError("");
            }
        } else {
            Common.CloseKeyBoard(login_activity,view);
            Api.getService().login(email, pass).enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    progBar.setVisibility(View.GONE);
                    if (response.isSuccessful()) {
                        login_activity.openHome(response.body());
                    } else {
                        Log.e("Error", response.code()+""+response.errorBody()+"");
                        Common.CreateErrorAlertDialog(login_activity, response.message());

                    }
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {
                    progBar.setVisibility(View.GONE);
                    Log.e("Error", t.getMessage());
                    Common.CreateErrorAlertDialog(login_activity, "Faild");

                }
            });
        }
    }


}
